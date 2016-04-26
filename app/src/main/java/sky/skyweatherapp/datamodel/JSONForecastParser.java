package sky.skyweatherapp.datamodel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class JSONForecastParser implements ForecastParser {
    private String TAG = "JSONForecastParser";

    @Override
    public List<ForecastItem> parseForecast(String data) {

        List<ForecastItem> forecastItems = new ArrayList<>();

        try {
            JSONObject forecastData = new JSONObject(data);

            JSONArray forecasts = forecastData.getJSONArray("list");

            for (int i = 0; i < forecasts.length(); i++) {

                JSONObject forecast = forecasts.getJSONObject(i);
                JSONObject wind = forecast.getJSONObject("wind");

                forecastItems.add(new ForecastItem(forecast.getLong("dt"), wind.getDouble("speed"), wind.getDouble("deg")));
            }

        } catch (Exception ex) {
        }


        return forecastItems;
    }
}
