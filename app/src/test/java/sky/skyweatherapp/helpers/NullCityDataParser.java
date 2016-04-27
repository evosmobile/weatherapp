package sky.skyweatherapp.helpers;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.CityDataParser;

/**
 * Created by SMcD on 25/04/2016.
 */
public class NullCityDataParser implements CityDataParser {
    @Override
    public List<CityData> parseCitySearchResponse(String citySearchResponseJSON) throws Exception {
        return null;
    }
}
