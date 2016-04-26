package sky.skyweatherapp.helpers;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.ForecastItem;
import sky.skyweatherapp.datamodel.ForecastParser;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class NULLForecastParser implements ForecastParser {
    @Override
    public List<ForecastItem> parseForecast(String data) {
        return new ArrayList<>();
    }
}
