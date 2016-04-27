package sky.skyweatherapp.datamodel;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.helpers.FavouriteCitiesRetriever;

/**
 * Created by SMcD on 25/04/2016.
 */
public class MainScreenDataModel {


    private static final String TAG = "MainDataModel";
    private final String apiKey;
    private final FavouriteCitiesRetriever favouriteCitiesRetriever;
    private final CityDataParser cityDataParser;

    private List<CityData> favourites = new ArrayList<>();
    private String countryUrl;


    public MainScreenDataModel(String apiKey, FavouriteCitiesRetriever favouriteCitiesRetriever, CityDataParser cityDataParser) {
        this.apiKey = apiKey;
        this.favouriteCitiesRetriever = favouriteCitiesRetriever;
        this.cityDataParser = cityDataParser;
    }

    public List<CityData> parseCitySearchResponse(String cityData) throws Exception {
        return cityDataParser.parseCitySearchResponse(cityData);
    }


    public void retrieveFavourites() {
        favourites = favouriteCitiesRetriever.retrieveFavourites();
    }

    public void addFavourite(CityData cityData) {
        favourites.add(cityData);
        favouriteCitiesRetriever.saveFavourites(favourites);
    }

    public List<CityData> getFavourites() {
        return favourites;
    }

    public void deleteFavourite(CityData cityData) {
        for (int x=favourites.size()-1;x>=0;x--) {
            if (favourites.get(x).getId()==cityData.getId()) {
                favourites.remove(x);
            }
        }
        favouriteCitiesRetriever.saveFavourites(favourites);
    }

    public String getCountryUrl(String query) {
        String safeQuery = null;
        try {
            safeQuery = URLEncoder.encode(query,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "getCountryUrl:"+e.toString() );
        }
        return String.format("http://api.openweathermap.org/data/2.5/find?q=%s&type=like&sort=population&cnt=50&appid=%s&mode=json",safeQuery,apiKey);
    }
}
