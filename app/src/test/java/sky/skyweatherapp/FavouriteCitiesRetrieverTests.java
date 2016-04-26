package sky.skyweatherapp;

import android.provider.ContactsContract;

import org.junit.Test;

import java.util.List;

import sky.skyweatherapp.datamodel.CityData;
import sky.skyweatherapp.datamodel.DataModel;
import sky.skyweatherapp.helpers.FavouriteCitiesRetriever;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class FavouriteCitiesRetrieverTests {

    @Test
    public void whenANewFavouriteIsAddedToTheDataModel_theRetrieverIsCalledToUpdateTheStore() {

        CapturingFavouriteCitiesRetriever capturingFavouriteCitiesRetriever = new CapturingFavouriteCitiesRetriever();

        DataModel model = new DataModel(null, capturingFavouriteCitiesRetriever, null, null);

        model.addFavourite(new CityData(1,"Name","Country"));


        assertThat(capturingFavouriteCitiesRetriever.updateCalled, is(true));
    }


    private class CapturingFavouriteCitiesRetriever implements FavouriteCitiesRetriever {
        public Boolean updateCalled = false;

        @Override
        public List<CityData> retrieveFavourites() {
            return null;
        }

        @Override
        public void saveFavourites(List<CityData> favourites) {
            updateCalled = true;
        }
    }
}
