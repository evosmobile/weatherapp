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

    @Test
    public void givenAJsonResponseTheModelIsPopulatedWithTheCorrectData() throws JSONException {
        DataModel model = new DataModel();
        List<CityData> cityResults = model.parseCitySearchResponse(TestData.sampleCityData);

        CityData first = cityResults.get(0);
        CityData second = cityResults.get(1);
        CityData third = cityResults.get(2);
        CityData fourth = cityResults.get(3);

        assertThat(first.getId(), is(5089178L));
        assertThat(first.getName(), is("Manchester"));
        assertThat(first.getCountry(), is("US"));

    }


    private class DataModel {

        public List<CityData> parseCitySearchResponse(String citySearchResponseJSON) throws JSONException {

            List<CityData> returnValue = new ArrayList<>();

            JSONObject json = new JSONObject(citySearchResponseJSON);
            JSONArray cities = json.getJSONArray("list");

            for (int i=0;i<cities.length();i++) {
                final JSONObject cityObject = cities.getJSONObject(i);
                long id  = cityObject.getLong("id");
                String name = cityObject.getString("name");
                String country = cityObject.getJSONObject("sys").getString("country");

                returnValue.add(new CityData(id,name,country));
            }

            return returnValue;
        }
    }

    private class CityData {

        private long id;
        private String name;
        private String country;

        public CityData(long id, String name, String country) {
            this.id = id;
            this.name = name;
            this.country = country;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }
    }
}
