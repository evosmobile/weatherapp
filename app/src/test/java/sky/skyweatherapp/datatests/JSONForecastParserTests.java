package sky.skyweatherapp.datatests;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.ForecastItem;
import sky.skyweatherapp.datamodel.ForecastParser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class JSONForecastParserTests {

    @Test
    public void givenAJSONForecast_theParserReturnsTheCorrectNumberOfItems() {

        JSONForecastParser parser = new JSONForecastParser();

        List<ForecastItem> forecastItems = parser.parseForecast(TestData.sampleForecastData);

        assertThat(forecastItems.size(), is(3));
    }



    private class JSONForecastParser implements ForecastParser {
        private String TAG = "JSONForecastParser";

        @Override
        public List<ForecastItem> parseForecast(String data) {

            List<ForecastItem> forecastItems = new ArrayList<>();

            try {
                JSONObject forecast = new JSONObject(data);

                JSONArray forecasts = forecast.getJSONArray("list");

                for (int i = 0; i<forecasts.length(); i++) {
                    forecastItems.add(new ForecastItem(0.0d, 0.0d));
                }



            } catch (Exception ex) {
            }


            return forecastItems;
        }
    }
}
