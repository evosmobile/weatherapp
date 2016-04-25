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

    public List<CityData> retrieveFavourites() {
        return favouriteCitiesRetriever.retrieveFavourites();
    }
}
