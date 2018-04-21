package com.danieldogeanu.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * MediaControlsFragment class displays the Media Controls in every Activity.
 * NOTE: This class has only a decorative role momentary. The Controls are not functional yet
 * and will be updated in a future version of the app.
 */
public class MediaControlsFragment extends Fragment {

    /** Empty MediaControlsFragment Constructor. */
    public MediaControlsFragment() {}

    /**
     * Overrides the onCreateView() method to assemble and display the Media Controls.
     * @param inflater The layout inflater.
     * @param container The container view.
     * @param savedInstanceState The Bundle for the Saved Instance State.
     * @return Returns the assembled Media Controls to display in all Activities.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Set the Root View and attach it to the Container
        View rootView = inflater.inflate(R.layout.media_controls, container, false);

        // Set demo durations for the Seek Bar
        Utils.setTextToView(rootView, R.id.seekCurrentTime, "0:00");
        Utils.setTextToView(rootView, R.id.seekTotalTime, "4:23");

        // Return the fully assembled Media Controls
        return rootView;
    }

}
