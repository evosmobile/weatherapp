package sky.skyweatherapp.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.R;
import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.ForecastItem;
import sky.skyweatherapp.datamodel.ForecastModel;
import sky.skyweatherapp.datamodel.JSONForecastParser;
import sky.skyweatherapp.presenters.ForecastScreenPresenter;
import sky.skyweatherapp.services.NetworkFetcherService;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class ForecastActivity extends AppCompatActivity implements ForecastView, NetworkFetcherService.NetworkCallCompleteCallback {

    private CityData cityData;
    private ForecastModel forecastModel;
    private ForecastScreenPresenter presenter;
    private NetworkFetcherService networkFetcherService;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            NetworkFetcherService.ServiceBinder binder = (NetworkFetcherService.ServiceBinder) service;
            networkFetcherService = binder.getService();

            networkFetcherService.setCallback(ForecastActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onPause() {
        super.onPause();

        unbindService(serviceConnection);
    }

    private DataRetrievedCallback dataRetrievedCallback;
    private RecyclerView forecastList;
    private ForecastDataAdapter forecastDataAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forecast);

        forecastDataAdapter = new ForecastDataAdapter();

        forecastList = (RecyclerView) findViewById(R.id.forecast_list);
        forecastList.setLayoutManager(new LinearLayoutManager(this));
        forecastList.setAdapter(forecastDataAdapter);


        Intent i = getIntent();
        this.cityData = new CityData(i.getLongExtra("id", -1), i.getStringExtra("name"), i.getStringExtra("country"));

        forecastModel = new ForecastModel(getString(R.string.api_key), cityData.getId(), new JSONForecastParser());
        presenter = new ForecastScreenPresenter(this, forecastModel);

        ((TextView)findViewById(R.id.forecast_place)).setText(cityData.getName());


    }

    @Override
    public void retrieveForecast(String url) {

        Intent i = new Intent(this, NetworkFetcherService.class);
        i.putExtra("url", url);
        i.putExtra("message", getString(R.string.downloading_forecast));

        bindService(i, serviceConnection, Context.BIND_AUTO_CREATE);
        startService(i);

    }

    @Override
    public void setDataRetrievedCallback(DataRetrievedCallback callback) {
        this.dataRetrievedCallback = callback;
    }

    @Override
    public void setForecastData(final List<ForecastItem> forecastItems) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                forecastDataAdapter.setForecastItems(forecastItems);
                forecastDataAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void networkCallComplete(String response) {
        dataRetrievedCallback.dataRetrieved(response);
    }

    private class ForecastDataAdapter extends RecyclerView.Adapter {

        private List<ForecastItem> forecastItems = new ArrayList<>();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v =  getLayoutInflater().inflate(R.layout.forecast_listitem, parent,false);
            return new ForecastListItem(v);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ForecastListItem listItem = (ForecastListItem)holder;
            listItem.setData(position, forecastItems.get(position));
        }

        @Override
        public int getItemCount() {
            return forecastItems.size();
        }

        public void setForecastItems(List<ForecastItem> forecastItems) {
            this.forecastItems = forecastItems;
        }
    }

    private class ForecastListItem extends RecyclerView.ViewHolder {

        private final TextView date;
        private final TextView time;
        private final TextView direction;
        private final TextView speed;
        private ForecastItem forecastItem;



        public ForecastListItem(View itemView) {
            super(itemView);

            date = (TextView)itemView.findViewById(R.id.forecast_item_date);
            time = (TextView)itemView.findViewById(R.id.forecast_item_time);
            direction = (TextView)itemView.findViewById(R.id.forecast_item_direction);
            speed = (TextView)itemView.findViewById(R.id.forecast_item_speed);
        }

        public void setData(int position, ForecastItem forecastItem) {
            this.forecastItem = forecastItem;

            DateFormat dateFormat = new SimpleDateFormat("dd MMM");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm");

            date.setText(dateFormat.format(forecastItem.getDatetime() * 1000));
            time.setText(timeFormat.format(forecastItem.getDatetime() * 1000));
            direction.setText(getCardinalString(forecastItem.getDirection()));
            speed.setText(String.format("%.2f m/s", forecastItem.getSpeed()));

            //Hide date except on first forecast of day
            if (position!=0 && !(time.getText().equals("01:00"))) {
                date.setVisibility(View.GONE);
            }
            else  {
                date.setVisibility(View.VISIBLE);
            }

        }
    }

    private String getCardinalString(double direction) {

        if (direction>=347.75 || direction<11.25) {
            return "N";
        } else if (direction>=11.25 && direction<33.75) {
            return "NNE";
        } else if (direction>=33.75 && direction<56.25) {
            return "NE";
        }else if (direction>=56.25 && direction<78.75) {
            return "ENE";
        }else if (direction>=78.75 && direction<101.25) {
            return "N";
        }else if (direction>=101.25 && direction<123.75) {
            return "ESE";
        }else if (direction>=123.75 && direction<146.25) {
            return "SE";
        }else if (direction>=146.25 && direction<168.75) {
            return "SSE";
        }else if (direction>=168.75 && direction<191.25) {
            return "S";
        }else if (direction>=191.25 && direction<213.75) {
            return "SSW";
        }else if (direction>=213.75 && direction<236.25) {
            return "SW";
        }else if (direction>=236.25 && direction<258.75) {
            return "WSW";
        }else if (direction>=258.75 && direction<281.25) {
            return "W";
        }else if (direction>=281.25 && direction<303.75) {
            return "WNW";
        }else if (direction>=303.75 && direction<326.25) {
            return "NW";
        }else if (direction>=326.25 && direction<347.75) {
            return "NNW";
        }
        return "UNK";
    }
}
