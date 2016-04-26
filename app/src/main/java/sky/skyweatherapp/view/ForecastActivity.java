package sky.skyweatherapp.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import sky.skyweatherapp.R;
import sky.skyweatherapp.datamodel.CityData;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forecast);

        Intent i = getIntent();
        this.cityData = new CityData(i.getLongExtra("id", -1), i.getStringExtra("city"), i.getStringExtra("country"));

        forecastModel = new ForecastModel(getString(R.string.api_key), cityData.getId(), new JSONForecastParser());

        presenter = new ForecastScreenPresenter(this, forecastModel);


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

    }

    @Override
    public void networkCallComplete(String response) {

    }
}
