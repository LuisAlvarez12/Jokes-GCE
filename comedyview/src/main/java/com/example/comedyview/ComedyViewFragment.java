package com.example.comedyview;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.R.attr.x;

/**
 * A placeholder fragment containing a simple view.
 */
public class ComedyViewFragment extends Fragment {


    private TextView tv_q,tv_a,tv_prev,tv_next;
    private int arrayIndex;
    private  String[] questionArray;
    public ComedyViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comedy_view, container, false);
         tv_q = (TextView)view.findViewById(R.id.question);
         tv_a = (TextView)view.findViewById(R.id.answer);
        tv_prev = (TextView)view.findViewById(R.id.prev);
        tv_next = (TextView)view.findViewById(R.id.next);

        tv_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevQuestion();
            }
        });

        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });

        arrayIndex = 0;
        questionArray = getActivity().getIntent().getStringExtra(getActivity().getResources().getString(R.string.key_intent)).split("\\|");
        splitQandA(questionArray[arrayIndex]);
        return view;
    }

    private void splitQandA(String s){
        String[] arr = s.split("0");
        tv_q.setText(arr[0]);
        tv_a.setText(arr[1]);
    }

    private void nextQuestion(){
    arrayIndex++;
        if(arrayIndex == questionArray.length){
            arrayIndex = 0;
        }
        splitQandA(questionArray[arrayIndex]);
    }

    private void prevQuestion(){
        arrayIndex--;
        if(arrayIndex == -1){
            arrayIndex = questionArray.length-1;
        }
        splitQandA(questionArray[arrayIndex]);
    }
}
