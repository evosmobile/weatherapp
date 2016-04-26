package sky.skyweatherapp.helpers;

import sky.skyweatherapp.datamodel.CurrentWeatherRetriever;

/**
 * Created by S on 25/04/2016.
 */
public class NullCurrentWeatherRetriever implements CurrentWeatherRetriever {
    @Override
    public String retrieve(String url) {
        return null;
    }
}
