package sky.skyweatherapp.datamodel;

import java.util.List;

/**
 * Created by S on 25/04/2016.
 */
public interface CityDataParser {

    List<CityData> parseCitySearchResponse(String citySearchResponseJSON) throws Exception;
}
