package sky.skyweatherapp.datamodel;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.helpers.FavouriteCitiesRetriever;

/**
 * Created by S on 25/04/2016.
 */
public class MainScreenDataModel {


    private final String apiKey;
    private final FavouriteCitiesRetriever favouriteCitiesRetriever;
    private final CityDataParser cityDataParser;
    private final CurrentWeatherRetriever currentWeatherRetriever;

    private final String API_ForecastRetrieve = "http://api.openweathermap.org/data/2.5/forecast?id=%d&appid=%s";
    private List<CityData> favourites = new ArrayList<>();


    public MainScreenDataModel(String apiKey, FavouriteCitiesRetriever favouriteCitiesRetriever, CityDataParser cityDataParser, CurrentWeatherRetriever currentWeatherRetriever) {
        this.apiKey = apiKey;
        this.favouriteCitiesRetriever = favouriteCitiesRetriever;
        this.cityDataParser = cityDataParser;
        this.currentWeatherRetriever = currentWeatherRetriever;
    }

    public List<CityData> parseCitySearchResponse(String cityData) throws Exception {
        return cityDataParser.parseCitySearchResponse(cityData);
    }

    public void retrieveForecast(long cityId) {

        String retrieveUrl = String.format(API_ForecastRetrieve, cityId, apiKey);

        String response = currentWeatherRetriever.retrieve(retrieveUrl);

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
