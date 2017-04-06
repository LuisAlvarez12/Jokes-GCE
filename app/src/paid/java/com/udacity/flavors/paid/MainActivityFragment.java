package com.udacity.flavors.paid;


/**
 * Created by luisalvarez on 4/5/17.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.GCEAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends android.app.Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button toJoke = (Button)root.findViewById(R.id.btn_joke);
        toJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GCEAsyncTask gceAsyncTask = new GCEAsyncTask();
                gceAsyncTask.execute(getActivity());
            }
        });
        return root;
    }
}