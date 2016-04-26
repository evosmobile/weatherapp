package sky.skyweatherapp.datatests;

import org.junit.Test;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.MainScreenDataModel;
import sky.skyweatherapp.helpers.CapturingFavouriteCitiesRetriever;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class FavouriteCitiesRetrieverTests {

    @Test
    public void whenANewFavouriteIsAddedToTheDataModel_theRetrieverIsCalledToUpdateTheStore() {

        CapturingFavouriteCitiesRetriever capturingFavouriteCitiesRetriever = new CapturingFavouriteCitiesRetriever();

        MainScreenDataModel model = new MainScreenDataModel(null, capturingFavouriteCitiesRetriever, null, null);

        model.addFavourite(new CityData(1,"Name","Country"));

        assertThat(capturingFavouriteCitiesRetriever.updateCalled, is(true));
    }


}
