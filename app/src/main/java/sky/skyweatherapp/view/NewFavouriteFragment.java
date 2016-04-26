package sky.skyweatherapp.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.R;
import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.services.NetworkFetcherService;

/**
 * Created by S on 25/04/2016.
 */
public class NewFavouriteFragment extends DialogFragment implements NetworkFetcherService.NetworkCallCompleteCallback {

    private View inflatedView;
    private NetworkFetcherService networkService;
    private RecyclerView citiesList;
    private EditText searchCriteria;
    private CitiesAdapter citiesAdapter;


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            NetworkFetcherService.ServiceBinder binder = (NetworkFetcherService.ServiceBinder) service;
            networkService = binder.getService();

            networkService.setCallback(NewFavouriteFragment.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void setCountriesListData(List<CityData> cityData) {
        citiesAdapter.setData(cityData);
        citiesAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        getDialog().setTitle(getString(R.string.dialog_title));

        inflatedView = inflater.inflate(R.layout.new_favourite_fragment, null);

        inflatedView.findViewById(R.id.newfavourite_search).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);


                //TODO: Refactor
                String cityName = searchCriteria.getText().toString();
                String url = String.format("http://api.openweathermap.org/data/2.5/find?q=%s&type=like&sort=population&cnt=50&appid=cf9d82cc9699db27242567f0cefbfce5&mode=json", cityName);

                Intent i = new Intent(getContext(), NetworkFetcherService.class);
                i.putExtra("url", url);
                i.putExtra("message", getString(R.string.searching));

                getActivity().bindService(i, serviceConnection, Context.BIND_AUTO_CREATE);
                getActivity().startService(i);

            }

        });

        searchCriteria = (EditText) inflatedView.findViewById(R.id.newfavourite_cityname);
        citiesList = (RecyclerView) inflatedView.findViewById(R.id.newfavourite_list);
        citiesList.setLayoutManager(new LinearLayoutManager(getContext()));

        citiesAdapter = new CitiesAdapter();
        citiesList.setAdapter(citiesAdapter);

        return inflatedView;
    }

    @Override
    public void networkCallComplete(final String response) {

        MainScreenActivity mainScreenActivity = (MainScreenActivity) getActivity();
        mainScreenActivity.getPresenterCallback().cityDataRetrieved(response);

    }

    private class CitiesAdapter extends RecyclerView.Adapter {
        private List<CityData> cityData = new ArrayList<>();

        public void setData(List<CityData> cityData) {
            this.cityData = cityData;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = getLayoutInflater(null).inflate(R.layout.country_list_item, parent, false);
            return new CitiesListItem(v);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            CitiesListItem item = (CitiesListItem) holder;
            item.setData(cityData.get(position));
        }

        @Override
        public int getItemCount() {
            return cityData.size();
        }
    }

    private class CitiesListItem extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView city;
        TextView country;
        private CityData cityData;

        public CitiesListItem(View itemView) {
            super(itemView);

            city = (TextView) itemView.findViewById(R.id.cityitemholder_city);
            country = (TextView) itemView.findViewById(R.id.cityitemholder_country);

            itemView.setOnClickListener(this);
        }

        public void setData(CityData cityData) {
            this.cityData = cityData;
            city.setText(cityData.getName());
            country.setText(cityData.getCountry());
        }

        @Override
        public void onClick(View v) {
            MainScreenActivity mainScreenActivity = (MainScreenActivity) getActivity();
            mainScreenActivity.getPresenterCallback().newFavouriteCitySelected(cityData);

        }

    }
}
