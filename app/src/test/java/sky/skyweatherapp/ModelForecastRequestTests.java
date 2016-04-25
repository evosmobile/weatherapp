package sky.skyweatherapp;

import org.junit.Test;

import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.datamodel.ForecastRetriever;
import sky.skyweatherapp.helpers.NullCityDataParser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by S on 25/04/2016.
 */
public class ModelForecastRequestTests {



    @Test
    public void givenACityIDTheModelWillGenerateTheCorrectNetworkRequest() {

        String testKey = "1234567890";

        CapturingForecastRetriever capturingForecastRetriever = new CapturingForecastRetriever();

        DataModel model = new DataModel(new NullCityDataParser());

        model.retrieveForecast(2643123L);

        String expectedUrl = "http://api.openweathermap.org/data/2.5/forecast?id=2643123&appid=" + testKey;

        assertThat(capturingForecastRetriever.capturedUrl, is(expectedUrl));

    }

    private class CapturingForecastRetriever implements ForecastRetriever {
        public String capturedUrl;



    }
}
