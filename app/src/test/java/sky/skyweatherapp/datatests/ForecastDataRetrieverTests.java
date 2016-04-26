package sky.skyweatherapp.datatests;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class ForecastDataRetrieverTests {

    @Test
    public void givenACityID_theModelRequestsTheCorrectUrl() {

        CapturingForecastRetriever capturingForecastRetriever = new CapturingForecastRetriever();

        ForecastModel forecastModel = new ForecastModel("1234", capturingForecastRetriever);


        forecastModel.retrieveForecast(56789L);

        String expectedUrl = "http://api.openweathermap.org/data/2.5/forecast?id=56789&appid=1234";

        assertThat(capturingForecastRetriever.capturedUrl, is(expectedUrl));

    }

    private class CapturingForecastRetriever implements ForecastRetriever {

        public String capturedUrl;

        @Override
        public String retrieveForecast(String url) {
            capturedUrl = url;
            return "";
        }
    }

    interface ForecastRetriever {
        String retrieveForecast(String url);
    }

    private class ForecastModel {
        private String apiKey;
        private ForecastRetriever forecastRetriever;

        private String FORECAST_URL_FORMAT = "http://api.openweathermap.org/data/2.5/forecast?id=%d&appid=%s";

        public ForecastModel(String apiKey, ForecastRetriever forecastRetriever) {
            this.apiKey = apiKey;
            this.forecastRetriever = forecastRetriever;
        }

        public void retrieveForecast(long locationId) {

            String url = String.format(FORECAST_URL_FORMAT, locationId, apiKey);

            forecastRetriever.retrieveForecast(url);

        }
    }
}
