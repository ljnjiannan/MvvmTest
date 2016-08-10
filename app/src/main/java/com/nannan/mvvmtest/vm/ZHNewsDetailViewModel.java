package com.nannan.mvvmtest.vm;

import android.databinding.ObservableField;

import com.nannan.mvvmtest.base.vm.BaseViewModel;
import com.nannan.mvvmtest.entity.ZHNewsDetailEntity;
import com.nannan.mvvmtest.net.NetRequestFactory;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author ljnjiannan
 * @since 16/8/10.
 */

public class ZHNewsDetailViewModel extends BaseViewModel {

  private String storyId;

  public ZHNewsDetailEntity zhNewsDetailEntity;

  public ObservableField<String> body=new ObservableField<>();

  public ZHNewsDetailViewModel(String storyId) {
    this.storyId = storyId;
    initData();
  }

  private void initData(){
    if(storyId.isEmpty()){
      return;
    }
    NetRequestFactory.getsZHHomeService().getNewsDetail(storyId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<ZHNewsDetailEntity>() {
          @Override
          public void call(final ZHNewsDetailEntity entity) {
            zhNewsDetailEntity=entity;
            loadCss(entity.getCss().get(0));
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {

          }
        });

  }

  private void loadCss(String cssUrl){
    NetRequestFactory.getsZHHomeService().getCss(cssUrl)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<String>() {
          @Override
          public void call(final String css) {
            Observable.just(zhNewsDetailEntity.getBody())
                .map(new Func1<String, String>() {
                  @Override
                  public String call(String s) {
                    return s + "<style type=\"text/css\">" + css + "</style>";
                  }
                })
                .subscribe(new Action1<String>() {
                  @Override
                  public void call(String s) {
                    body.set(s);
                  }
                });
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {

          }
        });
  }
}
