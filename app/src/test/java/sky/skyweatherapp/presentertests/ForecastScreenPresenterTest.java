package sky.skyweatherapp.presentertests;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import sky.skyweatherapp.datamodel.ForecastItem;
import sky.skyweatherapp.datamodel.ForecastModel;
import sky.skyweatherapp.datamodel.ForecastParser;
import sky.skyweatherapp.helpers.NULLForecastParser;
import sky.skyweatherapp.presenters.ForecastScreenPresenter;
import sky.skyweatherapp.view.ForecastView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SMcDMcD on 26/04/16.
 */
public class ForecastScreenPresenterTest {

    private ForecastModel model;
    private InvokableCapturingForecastView invokableCapturingForecastView;
    private CapturingForecastParser capturingForecastParser = new CapturingForecastParser();

    @Before
    public void setup() {
        model = new ForecastModel("1234", 6789, capturingForecastParser);
        invokableCapturingForecastView = new InvokableCapturingForecastView();
    }

    @Test
    public void givenAModelAndAForecastScreenView_thePresenterCausesTheViewToRetrieveItsData() {

        ForecastScreenPresenter forecastScreenPresenter = new ForecastScreenPresenter(invokableCapturingForecastView, model);

        String expectedUrl = "http://api.openweathermap.org/data/2.5/forecast?id=6789&appid=1234";

        assertThat(invokableCapturingForecastView.capturedUrl, is(expectedUrl));
    }

    @Test
    public void whenAForecastViewRetrievesData_itInformsThePresenterWhichThenInvokesTheParser() {


        ForecastScreenPresenter presenter = new ForecastScreenPresenter(invokableCapturingForecastView, model);

        invokableCapturingForecastView.invokeDataRetrievedCallback();

        assertThat(capturingForecastParser.parseCalled, is(true));

    }


    class InvokableCapturingForecastView implements ForecastView {

        public String capturedUrl;
        DataRetrievedCallback callback;

        @Override
        public void retrieveForecast(String url) {
            capturedUrl = url;
        }

        @Override
        public void setDataRetrievedCallback(DataRetrievedCallback callback) {
            this.callback = callback;
        }

        @Override
        public void setForecastData(List<ForecastItem> forecastItems) {
        }

        public void invokeDataRetrievedCallback() {
            callback.dataRetrieved("some data");
        }
    }

    class CapturingForecastParser implements ForecastParser {

        public boolean parseCalled = false;

        @Override
        public List<ForecastItem> parseForecast(String data) {
            parseCalled = true;
            return null;
        }
    }

}
