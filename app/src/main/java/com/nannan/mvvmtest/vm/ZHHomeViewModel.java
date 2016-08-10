package com.nannan.mvvmtest.vm;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.nannan.mvvmtest.BR;
import com.nannan.mvvmtest.R;
import com.nannan.mvvmtest.base.vm.BaseRefreshRecyclerViewModel;
import com.nannan.mvvmtest.entity.ZHHomeEntity;
import com.nannan.mvvmtest.entity.ZHNewsItemEntity;
import com.nannan.mvvmtest.entity.ZHTopItemEntity;
import com.nannan.mvvmtest.net.NetRequestFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author ljnjiannan
 * @since 16/8/2.
 */
public class ZHHomeViewModel extends BaseRefreshRecyclerViewModel<ZHHomeItemViewModel> {

  public static final String Tag = "ZHHomeViewModel";

  public ZHHomeViewModel(Context mContext) {
    super(mContext);
  }

  @Override
  protected int getItemLayout() {
    return R.layout.item_news;
  }

  @Override
  protected void initViewModel() {
  }

  @Override
  protected void onRefreshing() {
    newsList.clear();
    initDataRequest();
  }

  @Override
  protected void onLoadMore() {
    NetRequestFactory.getsZHHomeService().getNewsStories(currentDate)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<ZHHomeEntity>() {
          @Override
          public void call(ZHHomeEntity zhHomeEntity) {
            List<ZHNewsItemEntity> newsItemEntities=zhHomeEntity.getStories();
            String date=zhHomeEntity.getDate();
            currentDate=date;
            ZHHomeItemViewModel dateModel = new ZHHomeItemViewModel();
            dateModel.setType(ZHHomeItemViewModel.TYPE_DATE);
            String d=changeDateFormat(date,ZHHomeItemViewModel.DAY_FORMAT,ZHHomeItemViewModel.DAY_UI_FORMAT);
            dateModel.setData(d);
            newsList.add(dateModel);
            for (ZHNewsItemEntity entity : newsItemEntities) {
              ZHHomeItemViewModel model = new ZHHomeItemViewModel();
              model.setType(ZHHomeItemViewModel.TYPE_SOTRY);
              model.setStoryItemModel(entity);
              newsList.add(model);
            }
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {

          }
        });
  }

  @Override
  protected void setitemView(ItemView itemView, int position, ZHHomeItemViewModel item) {
    if(item.getType()==ZHHomeItemViewModel.TYPE_SOTRY){
      itemView.set(BR.newsItem,R.layout.item_news);
    }else if(item.getType()==ZHHomeItemViewModel.TYPE_DATE){
      itemView.set(BR.newsItem,R.layout.item_news_date);
    }else if(item.getType()==ZHHomeItemViewModel.TYPE_TOP_SOTRY){
      itemView.set(BR.newsItem,R.layout.item_news_banner);
    }
  }

  @Override
  protected void initDataRequest() {
    NetRequestFactory.getsZHHomeService().getNewHome()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<ZHHomeEntity>() {
          @Override
          public void call(ZHHomeEntity zhHomeEntity) {
            List<ZHTopItemEntity> topItemEntityList = zhHomeEntity.getTopStories();
            List<ZHNewsItemEntity> newsItemEntities=zhHomeEntity.getStories();
            String date=zhHomeEntity.getDate();
            //设置头部数据
            ZHHomeItemViewModel topModel = new ZHHomeItemViewModel();
            topModel.setType(ZHHomeItemViewModel.TYPE_TOP_SOTRY);
            ObservableList<ZHTopItemEntity> topStoryItemModel =new ObservableArrayList<>();
            for (ZHTopItemEntity topItemEntity : topItemEntityList) {
              topStoryItemModel.add(topItemEntity);
            }
            topModel.setTopStoryItemModel(topStoryItemModel);
            newsList.add(topModel);

            ZHHomeItemViewModel dateModel = new ZHHomeItemViewModel();
            dateModel.setType(ZHHomeItemViewModel.TYPE_DATE);
            dateModel.setData("今日热文");
            newsList.add(dateModel);
            currentDate=date;
            for (ZHNewsItemEntity entity : newsItemEntities) {
              ZHHomeItemViewModel model = new ZHHomeItemViewModel();
              model.setType(ZHHomeItemViewModel.TYPE_SOTRY);
              model.setStoryItemModel(entity);
              newsList.add(model);
            }
            onRefreshComplete();
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {

          }
        });
  }

  private String changeDateFormat(String oldDate, SimpleDateFormat oldFormat, SimpleDateFormat newFormat) {
    Date date;
    try {
      date = oldFormat.parse(oldDate);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
    return newFormat.format(date);
  }

}
