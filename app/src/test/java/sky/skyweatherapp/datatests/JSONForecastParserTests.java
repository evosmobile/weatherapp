package sky.skyweatherapp.datatests;

import org.junit.Test;

import java.util.List;

import sky.skyweatherapp.datamodel.ForecastItem;
import sky.skyweatherapp.datamodel.JSONForecastParser;
import sky.skyweatherapp.helpers.TestData;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SMcDMcD on 26/04/16.
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


}
