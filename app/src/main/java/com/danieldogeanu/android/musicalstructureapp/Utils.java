package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Utils {

    public static void openActivity(final Activity thisActivity, int buttonId, final Class activityToOpen) {
        View button = (View) thisActivity.findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thisIntent = new Intent(thisActivity, activityToOpen);
                thisActivity.startActivity(thisIntent);
            }
        });
    }

    public static void deactivateMenuButton(final Activity thisActivity) {
        ImageButton menuButton = (ImageButton) thisActivity.findViewById(R.id.menuBtn);
        menuButton.setVisibility(View.GONE);
    }

    public static void deactivateBackButton(final Activity thisActivity) {
        ImageButton backButton = (ImageButton) thisActivity.findViewById(R.id.backBtn);
        backButton.setVisibility(View.GONE);
    }

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

    public static void setTextToView(final Activity thisActivity, int id, CharSequence text) {
        TextView thisTextView = (TextView) thisActivity.findViewById(id);
        thisTextView.setText(text);
    }

    public static void setTextToView(final View thisView, int id, CharSequence text) {
        TextView thisTextView = (TextView) thisView.findViewById(id);
        thisTextView.setText(text);
    }

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
