package com.example.photolibrary

import android.graphics.Bitmap
import com.squareup.picasso.Picasso

class FetchPhoto {

    fun fetchPhotoFromUrl(url : String) : Bitmap{
        return Picasso.get().load(url).get();
    }

}