package sky.skyweatherapp.presentertests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.datamodel.JSONCityDataParser;
import sky.skyweatherapp.datatests.TestData;
import sky.skyweatherapp.helpers.CannedFavouriteCities;
import sky.skyweatherapp.helpers.EmptyFavouriteCities;
import sky.skyweatherapp.helpers.NullCityDataParser;
import sky.skyweatherapp.helpers.NullFavouriteCitiesRetriever;
import sky.skyweatherapp.helpers.NullForecastRetriever;
import sky.skyweatherapp.presenters.MainScreenPresenter;
import sky.skyweatherapp.view.MainScreenView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by S on 25/04/2016.
 */
public class MainScreenPresenterTest {

    @Test
    public void givenADataModelIsProvided_thePresenterSetsUpTheScreenAsExpected() {

        CapturingInvokableMainScreenView capturingMainView = new CapturingInvokableMainScreenView();

        CannedFavouriteCities cannedFavouriteCities = new CannedFavouriteCities();
        DataModel model = new DataModel(null, cannedFavouriteCities, new NullCityDataParser(), new NullForecastRetriever());

        MainScreenPresenter presenter = new MainScreenPresenter(capturingMainView, model);

        assertThat(capturingMainView.capturedCities.size(), is(3));
    }

    @Test
    public void givenADataModelIsProvidedWithNoFavourites_ThenViewIsInstructedToDisplayTheNoFavouritesMessage() {
        CapturingInvokableMainScreenView capturingMainView = new CapturingInvokableMainScreenView();

        EmptyFavouriteCities emptyFavouriteCities = new EmptyFavouriteCities();
        DataModel model = new DataModel(null, emptyFavouriteCities, new NullCityDataParser(), new NullForecastRetriever());

        MainScreenPresenter presenter = new MainScreenPresenter(capturingMainView, model);

        assertThat(capturingMainView.capturedNoDataMessageDisplayed, is(true));

    }

    @Test
    public void whenACitySearchHasBeenPerformed_thePresenterIsNotified_andSetsTheListOfMatchesTheView() {

        CapturingInvokableMainScreenView capturingInvokableMainScreenView = new CapturingInvokableMainScreenView();
        DataModel model = new DataModel(null, new NullFavouriteCitiesRetriever(),new JSONCityDataParser(),new NullForecastRetriever());

        MainScreenPresenter presenter = new MainScreenPresenter(capturingInvokableMainScreenView, model);

        capturingInvokableMainScreenView.capturedCallback.cityDataRetrieved(TestData.sampleCityData);

        assertThat(capturingInvokableMainScreenView.capturedMatchedCities.size(), is(4));

    }

    @Test
    public void whenACitySearchResultHasBeenSelected_thePresenterIsNotified_andTheModelStoresItInItsListOfFavourites() {

        CapturingInvokableMainScreenView capturingInvokableMainScreenView = new CapturingInvokableMainScreenView();
        DataModel model = new DataModel(null, new NullFavouriteCitiesRetriever(), new NullCityDataParser(), new NullForecastRetriever());

        MainScreenPresenter presenter = new MainScreenPresenter(capturingInvokableMainScreenView,model);

        CityData expectedData = new CityData(1234, "CityName", "Country");


        capturingInvokableMainScreenView.invokeCitySelectedCallback(expectedData);

        assertThat(model.getFavourites().size(), is(1));
        assertThat(model.getFavourites().get(0).getId(),is(1234L));
        assertThat(model.getFavourites().get(0).getName(),is("CityName"));
        assertThat(model.getFavourites().get(0).getCountry(),is("Country"));
    }


    @Test
    public void whenACitySearchResultHasBeenSelected_thePresenterIsNotified_andItUpdatesTheListOnTheMainView() {
        CapturingInvokableMainScreenView capturingInvokableMainScreenView = new CapturingInvokableMainScreenView();
        DataModel model = new DataModel(null, new NullFavouriteCitiesRetriever(), new NullCityDataParser(), new NullForecastRetriever());

        MainScreenPresenter presenter = new MainScreenPresenter(capturingInvokableMainScreenView,model);

        CityData expectedData = new CityData(1234, "CityName", "Country");


        capturingInvokableMainScreenView.invokeCitySelectedCallback(expectedData);

        assertThat(capturingInvokableMainScreenView.capturedCities.size(),is(1));

        CityData capturedCity = capturingInvokableMainScreenView.capturedCities.get(0);
        assertThat(capturedCity.getCountry(), is("Country"));
        assertThat(capturedCity.getName(),is("CityName"));
        assertThat(capturedCity.getId(),is(1234L));
    }


    private class CapturingInvokableMainScreenView implements MainScreenView {
        public List<CityData> capturedCities = new ArrayList<>();
        public boolean capturedNoDataMessageDisplayed = false;
        public PresenterCallback capturedCallback = null;
        public List<CityData> capturedMatchedCities = new ArrayList<>();

        @Override
        public void setFavourites(List<CityData> cityData) {
            capturedCities = cityData;
        }

        @Override
        public void displayNoDataMessage() {
            capturedNoDataMessageDisplayed = true;
        }

        @Override
        public void setPresenterCallback(PresenterCallback presenterCallback) {
            capturedCallback = presenterCallback;
        }

        @Override
        public void setCitySearchResults(List<CityData> cityData) {
            capturedMatchedCities = cityData;
        }

        public void invokeCitySelectedCallback(CityData cityData) {
            capturedCallback.newFavouriteCitySelected(cityData);

        }
    }

}
