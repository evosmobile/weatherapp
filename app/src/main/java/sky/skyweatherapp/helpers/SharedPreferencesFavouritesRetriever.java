package sky.skyweatherapp.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import sky.skyweatherapp.datamodel.CityData;

/**
 * Created by mcdons20 on 26/04/16.
 */
public class SharedPreferencesFavouritesRetriever implements FavouriteCitiesRetriever {
    private static final String TAG = "SharedPrefsFavRetriever";
    private List<CityData> favourites = new ArrayList<>();
    private Context context;

    public SharedPreferencesFavouritesRetriever(Context context) {
        this.context = context;
    }

    @Override
    public List<CityData> retrieveFavourites() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("favourites", Context.MODE_PRIVATE);

        String json = sharedPreferences.getString("favourites", null);

        if (json!=null) {
            try {
                JSONObject jsonFavourites = new JSONObject(json);
                JSONArray favouriteItems = jsonFavourites.getJSONArray("favourites");

                for (int x = 0; x < favouriteItems.length(); x++) {
                    JSONObject currentFavourite = favouriteItems.getJSONObject(x);
                    CityData cityData = new CityData(currentFavourite.getLong("id"),
                            currentFavourite.getString("city"),
                            currentFavourite.getString("country"));

                    favourites.add(cityData);

                }
            } catch (Exception e) {
                Log.e(TAG, "retrieveFavourites: " + e.toString());
            }

        }

        return favourites;
    }

    @Override
    public void saveFavourites(List<CityData> favourites) {

        try {
            JSONArray favouritesArray = new JSONArray();

            for (CityData cityData : favourites) {

                JSONObject favourite = new JSONObject();

                favourite.put("id", cityData.getId());
                favourite.put("city", cityData.getName());
                favourite.put("country", cityData.getCountry());

                favouritesArray.put(favourite);

            }

            JSONObject jsonFavourites = new JSONObject();
            jsonFavourites.put("favourites", favouritesArray);

            SharedPreferences sharedPreferences = context.getSharedPreferences("favourites", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("favourites", jsonFavourites.toString());
            editor.commit();
        }
        catch (Exception ex) {
            Log.e(TAG, "saveFavourites: " + ex.toString());
        }

    }
}
