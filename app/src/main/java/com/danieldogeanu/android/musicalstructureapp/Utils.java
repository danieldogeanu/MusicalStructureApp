package com.danieldogeanu.android.musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

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

}
