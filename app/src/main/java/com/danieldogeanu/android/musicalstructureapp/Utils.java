package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Utilities class that contains common methods that are used repeatedly across the app.
 */
public class Utils {

    /**
     * Hides the Menu Button in Activities that it isn't required.
     * @param thisActivity The Activity from which this method is called.
     */
    public static void deactivateMenuButton(final Activity thisActivity) {
        ImageButton menuButton = (ImageButton) thisActivity.findViewById(R.id.menuBtn);
        menuButton.setVisibility(View.GONE);
    }

    /**
     * Shows and activates the Back Button in Activities that it's required.
     * @param thisActivity The Activity from which this method is called.
     */
    public static void activateBackButton(final Activity thisActivity) {
        ImageButton backButton = (ImageButton) thisActivity.findViewById(R.id.backBtn);
        backButton.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisActivity.finish();
            }
        });
    }

    /**
     * Sets text to the selected TextView.
     * @param thisActivity The Activity from which this method is called.
     * @param id The ID of the TextView to set the text.
     * @param text The text to set.
     */
    public static void setTextToView(final Activity thisActivity, int id, CharSequence text) {
        TextView thisTextView = (TextView) thisActivity.findViewById(id);
        thisTextView.setText(text);
    }

    /**
     * Sets text to the selected TextView.
     * @param thisView The View from which this method is called.
     * @param id The ID of the TextView to set the text.
     * @param text The text to set.
     */
    public static void setTextToView(final View thisView, int id, CharSequence text) {
        TextView thisTextView = (TextView) thisView.findViewById(id);
        thisTextView.setText(text);
    }

    /**
     * Method to set OnClickListener for the selected button and to attach Intent to open
     * either a Detail Activity or List Activity.
     * @param thisView The View from which this method is called.
     * @param id The ID of the Button that we want to set the listener and attach the intent.
     * @param activityToOpen The Activity Class that we want to open.
     * @param dataLabel The data label for the putExtra() method of the Intent.
     *                  We extract data by this label in the Activities we open with this Intent.
     * @param dataObject The data we want to send to the Activities we open with this Intent.
     */
    public static void addDetailsButtonIntent(final View thisView, int id, final Class activityToOpen, final String dataLabel, final Object dataObject) {
        ImageButton thisButton = (ImageButton) thisView.findViewById(id);
        thisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thisIntent = new Intent(thisView.getContext(), activityToOpen);
                if (dataObject instanceof Song) {
                    Song song = (Song) dataObject;
                    thisIntent.putExtra(dataLabel, song);
                } else if (dataObject instanceof Artist) {
                    Artist artist = (Artist) dataObject;
                    thisIntent.putExtra(dataLabel, artist);
                } else if (dataObject instanceof Album) {
                    Album album = (Album) dataObject;
                    thisIntent.putExtra(dataLabel, album);
                }
                thisView.getContext().startActivity(thisIntent);
            }
        });

    }

}
