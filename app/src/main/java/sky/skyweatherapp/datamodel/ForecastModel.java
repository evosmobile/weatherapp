package sky.skyweatherapp.datamodel;

import java.util.List;

/**
 * Created by SMcDMcD on 26/04/16.
 */
public class ForecastModel {
    private String apiKey;
    private long locationId;
    private ForecastParser forecastParser;

    private String FORECAST_URL_FORMAT = "http://api.openweathermap.org/data/2.5/forecast?id=%d&appid=%s";

    public ForecastModel(String apiKey, long locationId, ForecastParser forecastParser) {
        this.apiKey = apiKey;
        this.locationId = locationId;
        this.forecastParser = forecastParser;
    }

    public String getForecastUrl() {
        String url = String.format(FORECAST_URL_FORMAT, locationId, apiKey);
        return url;
    }

    public List<ForecastItem> parseResponsData(String response) {
        return forecastParser.parseForecast(response);
    }
}
