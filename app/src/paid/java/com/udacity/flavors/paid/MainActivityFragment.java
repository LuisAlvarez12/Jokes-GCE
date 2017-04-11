package com.udacity.flavors.paid;


/**
 * Created by luisalvarez on 4/5/17.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ldoublem.loadingviewlib.LVCircularCD;
import com.udacity.gradle.builditbigger.GCEAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends android.app.Fragment {
    private LVCircularCD anim;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        TextView toJoke = (TextView)root.findViewById(R.id.btn_joke);
        anim = (LVCircularCD)root.findViewById(R.id.lv_circularCD);

        toJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start the good stuff
                GCEAsyncTask gceAsyncTask = new GCEAsyncTask(anim,getActivity().getResources().getString(R.string.root_url));
                gceAsyncTask.execute(getActivity());
            }
        });
        return root;
    }
}