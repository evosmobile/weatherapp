package sky.skyweatherapp.presenters;

import java.util.List;

import sky.skyweatherapp.datamodel.ForecastItem;
import sky.skyweatherapp.datamodel.ForecastModel;
import sky.skyweatherapp.view.ForecastView;

/**
 * Created by SMcDMcD on 26/04/16.
 */
public class ForecastScreenPresenter implements ForecastView.DataRetrievedCallback{
    private final ForecastView forecastView;
    private final ForecastModel model;

    public ForecastScreenPresenter(ForecastView forecastView, ForecastModel model) {

        this.forecastView = forecastView;
        this.model = model;

        forecastView.setDataRetrievedCallback(this);

        forecastView.retrieveForecast(model.getForecastUrl());
    }

    @Override
    public void dataRetrieved(String response) {
        List<ForecastItem> forecastItems = model.parseResponsData(response);
        forecastView.setForecastData(forecastItems);
    }
}
