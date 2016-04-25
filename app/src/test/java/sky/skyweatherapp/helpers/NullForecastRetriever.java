package sky.skyweatherapp.helpers;

import sky.skyweatherapp.datamodel.ForecastRetriever;

/**
 * Created by S on 25/04/2016.
 */
public class NullForecastRetriever implements ForecastRetriever {
    @Override
    public String retrieve(String url) {
        return null;
    }
}
