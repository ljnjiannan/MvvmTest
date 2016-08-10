package com.nannan.mvvmtest.net;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ljnjiannan
 * @since 16/7/31.
 */
public final class ServiceGenerator {

  public static final String baseUrl = "http://news-at.zhihu.com/api/4/";

  public static <T> T createNormalService(Class<T> serviceClass){
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
        .create(serviceClass);
  }

  public static <T> T createCssStringService(Class<T> serviceClass){
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(new Converter.Factory() {
          @Override
          public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            return new ToStringConverter();
          }
        })
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
        .create(serviceClass);
  }
}
