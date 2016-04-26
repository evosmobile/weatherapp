package sky.skyweatherapp.presenters;

import sky.skyweatherapp.datamodel.ForecastModel;
import sky.skyweatherapp.view.ForecastView;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class ForecastScreenPresenter {
    private final ForecastView forecastView;
    private final ForecastModel model;

    public ForecastScreenPresenter(ForecastView forecastView, ForecastModel model) {

        this.forecastView = forecastView;
        this.model = model;

        forecastView.retrieveForecast(model.getForecastUrl());
    }
}
