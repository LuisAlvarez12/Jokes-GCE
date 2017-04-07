package com.udacity.flavors.free;


/**
 * Created by luisalvarez on 4/5/17.
 */

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.ldoublem.loadingviewlib.LVCircularCD;
import com.udacity.gradle.builditbigger.GCEAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends android.app.Fragment {

    private InterstitialAd mInterstitialAd;
    private LVCircularCD anim;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        TextView mToJoke = (TextView)root.findViewById(R.id.btn_joke);

        anim = (LVCircularCD)root.findViewById(R.id.lv_circularCD);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        InstantiateBanner(mAdView);
        mToJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InstantiateAd();
            }
        });

        return root;
    }

    private void InstantiateBanner(AdView mAdView) {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice(getActivity().getResources().getString(R.string.ad_id))
                .build();
        mAdView.loadAd(adRequest);
    }

    private void InstantiateAd() {
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                GCEAsyncTask asyncTask = new GCEAsyncTask(anim);
                asyncTask.execute(getActivity());
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                    mInterstitialAd.show();
            }
        });

        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(getActivity().getResources().getString(R.string.logger))
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}