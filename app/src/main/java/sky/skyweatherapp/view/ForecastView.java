package sky.skyweatherapp.view;

import java.util.List;

import sky.skyweatherapp.datamodel.ForecastItem;

/**
 * Created by mcdons20 on 26/04/16.
 */
public interface ForecastView {
    void retrieveForecast(String url);
    void setDataRetrievedCallback(DataRetrievedCallback callback);
    void setForecastData(List<ForecastItem> forecastItems);


    interface DataRetrievedCallback {
        void dataRetrieved(String response);
    }
}
