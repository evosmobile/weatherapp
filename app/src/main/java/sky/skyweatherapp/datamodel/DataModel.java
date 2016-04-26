package sky.skyweatherapp.datamodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.helpers.FavouriteCitiesRetriever;

/**
 * Created by S on 25/04/2016.
 */
public class DataModel {


    private final String apiKey;
    private final FavouriteCitiesRetriever favouriteCitiesRetriever;
    private final CityDataParser cityDataParser;
    private final ForecastRetriever forecastRetriever;

    private final String API_ForecastRetrieve = "http://api.openweathermap.org/data/2.5/forecast?id=%d&appid=%s";
    private List<CityData> favourites = new ArrayList<>();


    public DataModel(String apiKey, FavouriteCitiesRetriever favouriteCitiesRetriever, CityDataParser cityDataParser, ForecastRetriever forecastRetriever) {
        this.apiKey = apiKey;
        this.favouriteCitiesRetriever = favouriteCitiesRetriever;
        this.cityDataParser = cityDataParser;
        this.forecastRetriever = forecastRetriever;
    }

    public List<CityData> parseCitySearchResponse(String cityData) throws Exception {
        return cityDataParser.parseCitySearchResponse(cityData);
    }

    public void retrieveForecast(long cityId) {

        String retrieveUrl = String.format(API_ForecastRetrieve, cityId, apiKey);

        String response = forecastRetriever.retrieve(retrieveUrl);

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
}
