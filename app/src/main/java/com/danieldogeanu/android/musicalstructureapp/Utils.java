package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

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

}
