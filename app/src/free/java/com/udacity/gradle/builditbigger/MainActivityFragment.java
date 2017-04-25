package com.udacity.gradle.builditbigger;

import android.os.Binder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    @BindView(R.id.adView) AdView mAdView;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, root);
        //MobileAds.initialize(getActivity(), "ca-app-pub-3940256099942544~3347511713");
        MobileAds.initialize(getActivity()," ca-app-pub-4862241919033566~4119621734");
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        //AdRequest.Builder.addTestDevice("ABCDEF012345");
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
