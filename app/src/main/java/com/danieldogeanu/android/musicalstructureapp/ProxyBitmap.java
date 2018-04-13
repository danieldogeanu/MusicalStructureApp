package com.danieldogeanu.android.musicalstructureapp;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * ProxyBitmap Class makes the Bitmap Serializable so we can pass it to the Song object.
 */
public class ProxyBitmap implements Serializable {

    private final int [] pixels;
    private final int width, height;

    /**
     * ProxyBitmap Object Constructor used to make the Bitmap Serializable.
     * @param bitmap Takes one normal Bitmap and makes it Serializable.
     */
    public ProxyBitmap(Bitmap bitmap) {
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        pixels = new int [width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
    }

    /** @return Returns the original Bitmap for further use. */
    public Bitmap getBitmap() {
        return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);
    }

}
