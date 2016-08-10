package com.nannan.mvvmtest.net.service;

import com.nannan.mvvmtest.entity.ZHHomeEntity;
import com.nannan.mvvmtest.entity.ZHNewsDetailEntity;

import rx.Observable;

/**
 * @author ljnjiannan
 * @since 16/8/2.
 */
public interface ZHHomeService {

  Observable<ZHHomeEntity> getNewHome();

  Observable<ZHHomeEntity> getNewsStories(String date);

  Observable<ZHNewsDetailEntity> getNewsDetail(String id);

  Observable<String> getCss(String url);

}
