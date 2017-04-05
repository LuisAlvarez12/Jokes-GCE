package com.example.comedyview;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ComedyViewFragment extends Fragment {

    public ComedyViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comedy_view, container, false);
        TextView tv = (TextView)view.findViewById(R.id.joketext);
        tv.setText(getActivity().getIntent().getStringExtra("joke"));
        return view;
    }
}
