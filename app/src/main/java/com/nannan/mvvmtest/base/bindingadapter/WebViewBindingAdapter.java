package com.nannan.mvvmtest.base.bindingadapter;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.webkit.WebView;

/**
 * @author ljnjiannan
 * @since 16/8/10.
 */

public class WebViewBindingAdapter {
  @BindingAdapter("setBody")
  public static void setBody(WebView webView, final String body){
    if (body!=null&&!TextUtils.isEmpty(body)) {
      webView.loadDataWithBaseURL(null, body, "text/html", "UTF-8", null);
    }
  }

}
