package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.comedyview.ComedyView;
import com.example.luisalvarez.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.ldoublem.loadingviewlib.LVCircularCD;

import java.io.IOException;

import static android.graphics.Color.rgb;

/**
 * Created by luisalvarez on 4/6/17.
 */

public class GCEAsyncTask extends AsyncTask<Context, Void, String> {
    private MyApi myApiService = null;
    private Context context;
    private LVCircularCD animation;


    public GCEAsyncTask(LVCircularCD circularCD){
        Log.d("animation","created");
        animation = circularCD;


    }


    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokegetter-163622.appspot.com/_ah/api/");
            // end options for devappserver
            myApiService = builder.build();
            context = params[0];

        }

        try {
            return myApiService.generateJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("animation","started");
        animation.setVisibility(View.VISIBLE);
        animation.setViewColor(rgb(22, 160, 133));
        animation.startAnim();
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("animation","ended");
        animation.stopAnim();
        animation.setVisibility(View.GONE);
        Intent intent = new Intent(context, ComedyView.class);
        intent.putExtra(context.getResources().getString(R.string.key_intent),result);
        context.startActivity(intent);
    }
}