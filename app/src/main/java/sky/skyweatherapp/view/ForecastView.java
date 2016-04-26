package sky.skyweatherapp.view;

/**
 * Created by mcdons20 on 26/04/16.
 */
public interface ForecastView {
    void retrieveForecast(String url);

    void setDataRetrievedCallback(DataRetrievedCallback callback);


    interface DataRetrievedCallback {
        void dataRetrieved(String response);
    }
}
