package sky.skyweatherapp.datatests;

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

        assertThat(forecastItems.size(), is(40));
    }

    @Test
    public void givenAJSONForecast_theParserCorrectlySetsTheTimeWindSpeedAndDirection() {

        JSONForecastParser parser = new JSONForecastParser();

        List<ForecastItem> forecastItems = parser.parseForecast(TestData.sampleForecastData);

        ForecastItem forecastItem1 = forecastItems.get(0);

        assertThat(forecastItem1.getDatetime(), is(1461704400L));
        assertThat(forecastItem1.getSpeed(), is(5.95));
        assertThat(forecastItem1.getDirection(), is(127.001));


        ForecastItem forecastItem5 = forecastItems.get(4);

        assertThat(forecastItem5.getDatetime(), is(1461747600L));
        assertThat(forecastItem5.getSpeed(), is(3.97));
        assertThat(forecastItem5.getDirection(), is(122.501));

    }



    private class JSONForecastParser implements ForecastParser {
        private String TAG = "JSONForecastParser";

        @Override
        public List<ForecastItem> parseForecast(String data) {

            List<ForecastItem> forecastItems = new ArrayList<>();

            try {
                JSONObject forecastData = new JSONObject(data);

                JSONArray forecasts = forecastData.getJSONArray("list");

                for (int i = 0; i<forecasts.length(); i++) {

                    JSONObject forecast = forecasts.getJSONObject(i);
                    JSONObject wind = forecast.getJSONObject("wind");

                    forecastItems.add(new ForecastItem(forecast.getLong("dt"), wind.getDouble("speed"), wind.getDouble("deg")));
                }

            } catch (Exception ex) {
            }


            return forecastItems;
        }
    }
}
