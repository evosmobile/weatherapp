package sky.skyweatherapp.presentertests;

import org.junit.Test;

import sky.skyweatherapp.datamodel.ForecastModel;
import sky.skyweatherapp.helpers.NULLForecastParser;
import sky.skyweatherapp.presenters.ForecastScreenPresenter;
import sky.skyweatherapp.view.ForecastView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class ForecastScreenPresenterTest {

    @Test
    public void givenAModelAndAForecastScreenView_thePresenterCausesTheViewToRetrieveItsData() {

        CapturingForecastView capturingForecastView = new CapturingForecastView();

        ForecastModel model = new ForecastModel("1234", 6789, new NULLForecastParser());

        ForecastScreenPresenter forecastScreenPresenter = new ForecastScreenPresenter(capturingForecastView, model);

        String expectedUrl = "http://api.openweathermap.org/data/2.5/forecast?id=6789&appid=1234";

        assertThat(capturingForecastView.capturedUrl, is(expectedUrl));
    }

    class CapturingForecastView implements ForecastView {

        public String capturedUrl;

        @Override
        public String retrieveForecast(String url) {
            capturedUrl = url;
            return "";
        }
    }

}
