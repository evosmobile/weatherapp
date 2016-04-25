package sky.skyweatherapp.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sky.skyweatherapp.R;
import sky.skyweatherapp.services.NetworkFetcherService;

/**
 * Created by S on 25/04/2016.
 */
public class NewFavouriteFragment extends DialogFragment implements View.OnClickListener, NetworkFetcherService.NetworkCallCompleteCallback {

    private View inflatedView;
    private NetworkFetcherService networkService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            NetworkFetcherService.ServiceBinder binder = (NetworkFetcherService.ServiceBinder)service;
            networkService = binder.getService();

            networkService.setCallback(NewFavouriteFragment.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        inflatedView = inflater.inflate(R.layout.new_favourite_fragment, null);

        inflatedView.findViewById(R.id.newfavourite_search).setOnClickListener(this);


        builder.setView(inflatedView)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {



                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setTitle("Add new favourite");

        return builder.create();
    }

    @Override
    public void onClick(View v) {

        String cityName = ((EditText)inflatedView.findViewById(R.id.newfavourite_cityname)).getText().toString();
        String url = String.format("http://api.openweathermap.org/data/2.5/find?q=%s&type=like&sort=population&cnt=50&appid=cf9d82cc9699db27242567f0cefbfce5&mode=json",cityName);

        Intent i = new Intent(getContext(),NetworkFetcherService.class);
        i.putExtra("url",url);
        i.putExtra("message",getString(R.string.searching));

        getActivity().bindService(i,serviceConnection, Context.BIND_AUTO_CREATE);
        getActivity().startService(i);

    }

    @Override
    public void complete(String response) {
        Toast.makeText(getContext(), response,Toast.LENGTH_LONG).show();
    }
}
