package sky.skyweatherapp.view;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.R;
import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.MainScreenDataModel;
import sky.skyweatherapp.datamodel.CurrentWeatherRetriever;
import sky.skyweatherapp.datamodel.JSONCityDataParser;
import sky.skyweatherapp.helpers.SharedPreferencesFavouritesRetriever;
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

        String apiKey = getString(R.string.api_key);

        favouritesList = (RecyclerView) findViewById(R.id.main_favouritesList);
        favouritesList.setLayoutManager(new LinearLayoutManager(this));

        favouritesListAdapter = new FavouritesListAdapter();
        favouritesList.setAdapter(favouritesListAdapter);


        MainScreenDataModel model = new MainScreenDataModel(apiKey, new SharedPreferencesFavouritesRetriever(this), new JSONCityDataParser());

        MainScreenPresenter mainScreenPresenter = new MainScreenPresenter(this, model);

        findViewById(R.id.addNewFavouriteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                newFavouriteFragment = new NewFavouriteFragment();
                newFavouriteFragment.show(fragmentManager, null);
            }
        });
    }

    @Override
    public void setFavourites(List<CityData> cityData) {

        if (cityData.size()>0) {
            findViewById(R.id.main_nofavourites).setVisibility(View.INVISIBLE);
        }

        favouritesListAdapter.setCityData(cityData);
        favouritesListAdapter.notifyDataSetChanged();

    }


    @Override
    public void displayNoDataMessage() {

        findViewById(R.id.main_nofavourites).setVisibility(View.VISIBLE);

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

    @Override
    public void displayNewFavouriteMessage() {
        Toast.makeText(this, R.string.new_favourite_message, Toast.LENGTH_SHORT).show();
    }


    public PresenterCallback getPresenterCallback() {
        return presenterCallback;
    }

    private class JSONCurrentWeatherRetriever implements CurrentWeatherRetriever {
        @Override
        public String retrieve(String url) {
            return null;
        }
    }

    private class FavouritesListAdapter extends RecyclerView.Adapter {

        private static final int TYPE_HEADER = 2506;
        private static final int TYPE_ITEM = 1308;

        List<CityData> cityData = new ArrayList<>();

        public void setCityData(List<CityData> cityData) {
            this.cityData = cityData;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType==TYPE_ITEM) {
                View v = getLayoutInflater().inflate(R.layout.favourites_list_item, parent, false);
                return new FavouritesViewHolder(v);
            }
            else {
                View v = getLayoutInflater().inflate(R.layout.favourites_list_header, parent, false);
                return new FavouritesHeaderViewHolder(v);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (position>0) {
                FavouritesViewHolder viewHolder = (FavouritesViewHolder) holder;
                viewHolder.setData(cityData.get(position-1));
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position==0) {
                return TYPE_HEADER;
            } else {
                return TYPE_ITEM;
            }
        }

        @Override
        public int getItemCount() {
            return cityData.size()+1;
        }
    }

    public class FavouritesHeaderViewHolder extends RecyclerView.ViewHolder {
        public FavouritesHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class FavouritesViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        private final TextView city;
        private final TextView country;
        private CityData cityData;

        public FavouritesViewHolder(View itemView) {
            super(itemView);

            city = (TextView) itemView.findViewById(R.id.favouritesitem_city);
            country = (TextView) itemView.findViewById(R.id.favouritesitem_country);

            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
        }

        public void setData(CityData cityData) {
            this.cityData = cityData;
            city.setText(cityData.getName());
            country.setText(cityData.getCountry());
        }


        @Override
        public boolean onLongClick(View v) {
            PopupMenu menu = new PopupMenu(MainScreenActivity.this,v);
            MenuInflater inflater = menu.getMenuInflater();
            inflater.inflate(R.menu.favourites_popup, menu.getMenu());
            menu.setOnMenuItemClickListener(this);
            menu.show();

            return true;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            if (item.getItemId() == R.id.menu_delete) {
                MainScreenActivity.this.getPresenterCallback().deleteFavourite(cityData);
            }

            return false;
        }

        @Override
        public void onClick(View v) {

            Intent i = new Intent(MainScreenActivity.this, ForecastActivity.class);
            i.putExtra("id", cityData.getId());
            i.putExtra("name", cityData.getName());
            i.putExtra("country", cityData.getCountry());

            startActivity(i);

        }
    }
}
