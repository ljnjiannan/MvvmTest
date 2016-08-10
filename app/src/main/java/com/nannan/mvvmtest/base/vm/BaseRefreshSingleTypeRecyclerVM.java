package com.nannan.mvvmtest.base.vm;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author ljnjiannan
 * @since 16/8/3.
 */
public abstract class BaseRefreshSingleTypeRecyclerVM<T> extends BaseRefreshRecyclerViewModel<T> {

  //初始化数据请求
  //protected void initDataRequest() {
  //  setInitDataRequestObservable().subscribeOn(Schedulers.io())
  //      .observeOn(AndroidSchedulers.mainThread())
  //      .subscribe(new Action1<T>() {
  //        @Override
  //        public void call(T baseEntity) {
  //          setInitRequestSuccess(baseEntity);
  //        }
  //      }, new Action1<Throwable>() {
  //        @Override
  //        public void call(Throwable throwable) {
  //
  //        }
  //      });
  //}

  protected void onRefreshing() {
    isRefreshing.set(true);
    setRefreshDataRequestObservable().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<T>() {
          @Override
          public void call(T baseEntity) {
            setRefreshRequestSuccess(baseEntity);
            isRefreshing.set(false);
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {

          }
        });
  }

  //设置初始化请求的Observable
  //protected abstract Observable<BaseViewModel> setInitDataRequestObservable();

  //设置下拉刷新请求的Observable
  protected abstract Observable<T> setRefreshDataRequestObservable();

  //初始化数据请求成功
  protected abstract void setInitRequestSuccess(T entity);

  //下拉刷新数据请求成功
  protected abstract void setRefreshRequestSuccess(T entity);

}
