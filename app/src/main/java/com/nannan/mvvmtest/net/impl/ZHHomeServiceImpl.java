package com.nannan.mvvmtest.net.impl;

import com.nannan.mvvmtest.entity.ZHHomeEntity;
import com.nannan.mvvmtest.entity.ZHNewsDetailEntity;
import com.nannan.mvvmtest.net.ServiceGenerator;
import com.nannan.mvvmtest.net.api.ZHHomeApi;
import com.nannan.mvvmtest.net.service.ZHHomeService;

import rx.Observable;

/**
 * @author ljnjiannan
 * @since 16/8/2.
 */
public class ZHHomeServiceImpl implements ZHHomeService{
  ZHHomeApi api;

  public ZHHomeServiceImpl() {
    api = ServiceGenerator.createNormalService(ZHHomeApi.class);
  }

  @Override
  public Observable<ZHHomeEntity> getNewHome() {
    return api.getNewHome();
 }

  @Override
  public Observable<ZHHomeEntity> getNewsStories(String date) {
    return api.getNewsStories(date);
  }

  @Override
  public Observable<ZHNewsDetailEntity> getNewsDetail(String id) {
    return api.getNewsDetail(id);
  }

  @Override
  public Observable<String> getCss(String url) {
    return ServiceGenerator.createCssStringService(ZHHomeApi.class).getCss(url);
  }

}
