package sky.skyweatherapp.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.net.MalformedURLException;
import java.net.URL;

import javax.security.auth.login.LoginException;

import sky.skyweatherapp.R;

/**
 * Created by S on 26/04/2016.
 */
public class NetworkFetcherService extends IntentService {

    public static final int NOTIFICATION_ID = 3637;
    private static final String TAG = "NetworkFetcherService";
    NetworkCallCompleteCallback callback =null;

    public NetworkFetcherService() {
        super("NetworkFetcherService");
    }


    public void setCallback(NetworkCallCompleteCallback callback) {
        this.callback = callback;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String message = intent.getStringExtra("message");
        String url = intent.getStringExtra("url");

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle(getString(R.string.downloading));
        builder.setContentText(message);
        builder.setSmallIcon(android.R.drawable.ic_dialog_map);
        builder.setProgress(0,0,true);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());

        String response = "";

        try {
            URL downloadUrl = new URL(url);
            response = IOUtils.toString(downloadUrl.openStream());

        } catch (Exception e) {
            Log.e(TAG, "onHandleIntent: " + e.toString() );
        } finally {

            manager.cancel(NOTIFICATION_ID);
            if (callback!=null) {
                callback.complete(response);
            }
        }
    }

    public interface NetworkCallCompleteCallback {
        void complete(String response);
    }

    public class ServiceBinder extends Binder {
        public NetworkFetcherService getService() {
            return NetworkFetcherService.this;
        }
    }
}
