package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MediaControlsFragment extends Fragment {

    public MediaControlsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.media_controls, container, false);

        Utils.setTextToView(rootView, R.id.seekCurrentTime, "0:00");
        Utils.setTextToView(rootView, R.id.seekTotalTime, "4:23");

        return rootView;
    }

}
