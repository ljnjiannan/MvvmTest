package com.nannan.mvvmtest.base.bindingadapter;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @author ljnjiannan
 * @since 16/8/10.
 */

public class ImageBindingAdapter {

  @BindingAdapter({"uri"})
  public static void loadImage(ImageView imageView, String uri) {
    if (!TextUtils.isEmpty(uri)) {
      imageView.setImageURI(Uri.parse(uri));
      Glide.with(imageView.getContext()).load(uri).into(imageView);
    }
  }


  @BindingAdapter({"uri"})
  public static void loadImage(ImageView imageView, List<String> uris) {
    if(uris!=null && uris.size()>0) {
      String imageUri = uris.get(0);
      if (!TextUtils.isEmpty(imageUri)) {
        imageView.setImageURI(Uri.parse(imageUri));
        Glide.with(imageView.getContext()).load(imageUri).into(imageView);
      }
    }
  }

}
