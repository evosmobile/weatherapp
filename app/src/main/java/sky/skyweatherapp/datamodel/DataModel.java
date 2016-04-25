package sky.skyweatherapp.datamodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S on 25/04/2016.
 */
public class DataModel {


    private final CityDataParser cityDataParser;

    public DataModel(CityDataParser cityDataParser) {
        this.cityDataParser = cityDataParser;
    }


    public List<CityData> parseCitySearchResponse(String cityData) throws Exception {
        return cityDataParser.parseCitySearchResponse(cityData);
    }

    public void retrieveForecast(long cityId) {

    }
}
