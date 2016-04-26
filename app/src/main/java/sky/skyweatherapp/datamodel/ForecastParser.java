package sky.skyweatherapp.datamodel;

import java.util.List;

/**
 * Created by mcdons20 on 26/04/16.
 */
public interface ForecastParser {
    List<ForecastItem> parseForecast(String data);
}
