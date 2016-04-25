package sky.skyweatherapp.presentertests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.helpers.CannedFavouriteCities;
import sky.skyweatherapp.helpers.EmptyFavouriteCities;
import sky.skyweatherapp.helpers.NullCityDataParser;
import sky.skyweatherapp.helpers.NullForecastRetriever;
import sky.skyweatherapp.presenters.MainScreenPresenter;
import sky.skyweatherapp.presenters.MainView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by S on 25/04/2016.
 */
public class MainScreenPresenterTest {

    @Test
    public void givenADataModelIsProvided_thePresenterSetsUpTheScreenAsExpected() {

        CapturingMainView capturingMainView = new CapturingMainView();

        CannedFavouriteCities cannedFavouriteCities = new CannedFavouriteCities();
        DataModel model = new DataModel(null, cannedFavouriteCities, new NullCityDataParser(), new NullForecastRetriever());

        MainScreenPresenter presenter = new MainScreenPresenter(capturingMainView, model);

        assertThat(capturingMainView.capturedCities.size(), is(3));
    }

    @Test
    public void givenADataModelIsProvidedWithNoFavourites_ThenViewIsInstructedToDisplayTheNoFavouritesMessage() {
        CapturingMainView capturingMainView = new CapturingMainView();

        EmptyFavouriteCities emptyFavouriteCities = new EmptyFavouriteCities();
        DataModel model = new DataModel(null, emptyFavouriteCities, new NullCityDataParser(), new NullForecastRetriever());

        MainScreenPresenter presenter = new MainScreenPresenter(capturingMainView, model);

        assertThat(capturingMainView.capturedNoDataMessageDisplayed, is(true));

    }


    private class CapturingMainView implements MainView {
        public List<CityData> capturedCities = new ArrayList<>();
        public boolean capturedNoDataMessageDisplayed = false;

        @Override
        public void setFavourites(List<CityData> cityData) {
            capturedCities = cityData;
        }

        @Override
        public void displayNoDataMessage() {
            capturedNoDataMessageDisplayed = true;
        }
    }

}
