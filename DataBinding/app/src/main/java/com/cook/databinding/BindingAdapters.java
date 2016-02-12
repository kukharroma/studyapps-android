package com.cook.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by roma on 12.02.16.
 */
public class BindingAdapters {

    @BindingAdapter({"bind:imageAsset"})
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .crossFade()
                .into(imageView);
    }
}
