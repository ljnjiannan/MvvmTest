package com.nannan.mvvmtest.net.api;

import com.nannan.mvvmtest.entity.ZHHomeEntity;
import com.nannan.mvvmtest.entity.ZHNewsDetailEntity;
import com.nannan.mvvmtest.net.UrlHelper;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @author ljnjiannan
 * @since 16/8/2.
 */
public interface ZHHomeApi {

  @GET(UrlHelper.HOME_URL)
  Observable<ZHHomeEntity> getNewHome();

  @GET(UrlHelper.HOME_URL_NEWS)
  Observable<ZHHomeEntity> getNewsStories(@Path("date") String date);

  @GET(UrlHelper.NEWS_DETAIL_URL)
  Observable<ZHNewsDetailEntity> getNewsDetail(@Path("id") String id);

  @GET
  Observable<String> getCss(@Url String url);
}
