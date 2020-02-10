package com.example.photolibrary

import android.graphics.Bitmap
import android.util.LruCache
import android.widget.ImageView

class ImageCaching {

    lateinit var imageHouse: LruCache<String, Bitmap>;

    fun saveImageInCache(key: String, bitmap: Bitmap): LruCache<String, Bitmap> {
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        val cacheMemory = maxMemory / 8;

        imageHouse = object : LruCache<String, Bitmap>(cacheMemory) {
            override fun sizeOf(key: String?, value: Bitmap?): Int {
                return bitmap.byteCount / 1024;
            }
        }

        return this.imageHouse
    }


    fun getImageFromCache(key: String): Bitmap? {
        if (key != "") {
            var bitmap : Bitmap = imageHouse.get (key)
            return bitmap
        }
        return null
    }

    fun loadImage(key : String, imageView : ImageView){
        if(key != ""){
            imageView.setImageBitmap(getImageFromCache(key));
        }
    }

}