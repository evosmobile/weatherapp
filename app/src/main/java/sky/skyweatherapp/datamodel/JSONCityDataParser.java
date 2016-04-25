package sky.skyweatherapp.datamodel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S on 25/04/2016.
 */
public class JSONCityDataParser implements CityDataParser {


    @Override
    public List<CityData> parseCitySearchResponse(String citySearchResponseJSON) throws Exception {
        List<CityData> returnValue = new ArrayList<>();

        JSONObject json = new JSONObject(citySearchResponseJSON);
        JSONArray cities = json.getJSONArray("list");

        for (int i = 0; i < cities.length(); i++) {
            final JSONObject cityObject = cities.getJSONObject(i);
            long id = cityObject.getLong("id");
            String name = cityObject.getString("name");
            String country = cityObject.getJSONObject("sys").getString("country");

            returnValue.add(new CityData(id, name, country));
        }

        return returnValue;
    }
}
