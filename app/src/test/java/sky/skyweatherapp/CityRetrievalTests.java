package sky.skyweatherapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by S on 25/04/2016.
 */
public class CityRetrievalTests {





    @Test
    public void givenAJsonResponseTheModelIdentifiesTheCorrectNumberOfCities() throws JSONException {

        DataModel model = new DataModel();

        List<CityData> cityResults = model.parseCitySearchResponse(TestData.sampleCityData);

        assertThat(cityResults.size(), is(4));

    }


    private class DataModel {

        public List<CityData> parseCitySearchResponse(String citySearchResponseJSON) throws JSONException {

            List<CityData> returnValue = new ArrayList<>();

            JSONObject json = new JSONObject(citySearchResponseJSON);
            JSONArray cities = json.getJSONArray("list");

            for (int i=0;i<cities.length();i++) {
                returnValue.add(new CityData());
            }

            return returnValue;
        }
    }

    private class CityData {

    }
}
