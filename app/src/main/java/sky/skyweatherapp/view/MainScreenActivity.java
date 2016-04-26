package sky.skyweatherapp.view;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.R;
import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.datamodel.ForecastRetriever;
import sky.skyweatherapp.datamodel.JSONCityDataParser;
import sky.skyweatherapp.helpers.FavouriteCitiesRetriever;
import sky.skyweatherapp.presenters.MainScreenPresenter;

public class MainScreenActivity extends FragmentActivity implements MainScreenView {

    private PresenterCallback presenterCallback = null;
    private NewFavouriteFragment newFavouriteFragment;
    private RecyclerView favouritesList;
    private FavouritesListAdapter favouritesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = getResources().getString(R.string.api_key);

        DataModel model = new DataModel(apiKey, new SharedPreferencesFavouritesRetriever(), new JSONCityDataParser(), new JSONForecastRetriever());

        MainScreenPresenter mainScreenPresenter = new MainScreenPresenter(this, model);

        findViewById(R.id.addNewFavouriteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                newFavouriteFragment = new NewFavouriteFragment();
                newFavouriteFragment.show(fragmentManager, null);
            }
        });

        favouritesList = (RecyclerView) findViewById(R.id.main_favouritesList);
        favouritesList.setLayoutManager(new LinearLayoutManager(this));

        favouritesListAdapter = new FavouritesListAdapter();

        favouritesList.setAdapter(favouritesListAdapter);

    }

    @Override
    public void setFavourites(List<CityData> cityData) {

        favouritesListAdapter.setCityData(cityData);
        favouritesListAdapter.notifyDataSetChanged();

    }

    @Override
    public void displayNoDataMessage() {
        Toast.makeText(this, "No cities selected", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenterCallback(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    @Override
    public void setCitySearchResults(final List<CityData> cityData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                newFavouriteFragment.setCountriesListData(cityData);
            }
        });
    }

    public PresenterCallback getPresenterCallback() {
        return presenterCallback;
    }

    private class SharedPreferencesFavouritesRetriever implements FavouriteCitiesRetriever {
        private List<CityData> favourites = new ArrayList<>();

        @Override
        public List<CityData> retrieveFavourites() {
            return favourites;
        }
    }

    private class JSONForecastRetriever implements ForecastRetriever {
        @Override
        public String retrieve(String url) {
            return null;
        }
    }

    private class FavouritesListAdapter extends RecyclerView.Adapter {

        List<CityData> cityData = new ArrayList<>();


        public void setCityData(List<CityData> cityData) {
            this.cityData = cityData;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = getLayoutInflater().inflate(R.layout.favourites_list_item, null);

            return new FavouritesViewHolder(v);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            FavouritesViewHolder viewHolder = (FavouritesViewHolder) holder;
            viewHolder.setData(cityData.get(position));

        }

        @Override
        public int getItemCount() {
            return cityData.size();
        }
    }

    private class FavouritesViewHolder extends RecyclerView.ViewHolder {

        private final TextView city;
        private final TextView country;

        public FavouritesViewHolder(View itemView) {
            super(itemView);

            city = (TextView) itemView.findViewById(R.id.favouritesitem_city);
            country = (TextView) itemView.findViewById(R.id.favouritesitem_country);

        }

        public void setData(CityData cityData) {
            city.setText(cityData.getName());
            country.setText(cityData.getCountry());
        }
    }
}
