package sky.skyweatherapp;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.CityDataParser;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.datamodel.JSONCityDataParser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by S on 25/04/2016.
 */
public class JSONCityDataParserTests {

    private DataModel model;
    private List<CityData> cityResults;

    @Before
    public void setup() throws Exception {

        CityDataParser cityDataParser = new JSONCityDataParser();

        model = new DataModel(cityDataParser);
        cityResults = model.parseCitySearchResponse(TestData.sampleCityData);
    }

    @Test
    public void givenAJsonResponseTheModelIdentifiesTheCorrectNumberOfCities() throws JSONException {

        assertThat(cityResults.size(), is(4));
    }

    @Test
    public void givenAJsonResponseTheModelIsPopulatedWithTheCorrectData() throws JSONException {

        CityData first = cityResults.get(0);
        CityData second = cityResults.get(1);
        CityData third = cityResults.get(2);
        CityData fourth = cityResults.get(3);

        assertThat(first.getId(), is(5089178L));
        assertThat(first.getName(), is("Manchester"));
        assertThat(first.getCountry(), is("US"));

        assertThat(second.getId(), is(2643123L));
        assertThat(second.getName(), is("Manchester"));
        assertThat(second.getCountry(), is("GB"));

    }


}
