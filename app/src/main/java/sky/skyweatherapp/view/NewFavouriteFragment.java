package sky.skyweatherapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sky.skyweatherapp.R;

/**
 * Created by S on 25/04/2016.
 */
public class NewFavouriteFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflatedFragment = inflater.inflate(R.layout.new_favourite_fragment,null);

        return inflatedFragment;
    }
}
