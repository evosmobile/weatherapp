package sky.skyweatherapp.datatests;

import org.junit.Test;

import sky.skyweatherapp.datamodel.ForecastModel;
import sky.skyweatherapp.datamodel.ForecastParser;
import sky.skyweatherapp.helpers.NULLForecastParser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SMcDMcD on 26/04/16.
 */
public class ForecastDataModelTests {

    @Test
    public void givenACityID_theModelGeneratesTheCorrectUrl() {

        ForecastModel forecastModel = new ForecastModel("1234", 56789, new NULLForecastParser());
        String expectedUrl = "http://api.openweathermap.org/data/2.5/forecast?id=56789&appid=1234";

        assertThat(forecastModel.getForecastUrl(), is(expectedUrl));
    }

}
