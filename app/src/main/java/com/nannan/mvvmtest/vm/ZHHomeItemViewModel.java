package com.nannan.mvvmtest.vm;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.view.View;

import com.nannan.mvvmtest.BR;
import com.nannan.mvvmtest.R;
import com.nannan.mvvmtest.activity.NewsDetailActivity;
import com.nannan.mvvmtest.conf.ExtraKey;
import com.nannan.mvvmtest.entity.ZHNewsItemEntity;
import com.nannan.mvvmtest.entity.ZHTopItemEntity;

import java.text.SimpleDateFormat;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * @author ljnjiannan
 * @since 16/8/8.
 */

public class ZHHomeItemViewModel {


  public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("yyyyMMdd");

  public static final SimpleDateFormat DAY_UI_FORMAT = new SimpleDateFormat("MM月dd日");

  public static final int TYPE_TOP_SOTRY=0;
  public static final int TYPE_SOTRY=1;
  public static final int TYPE_DATE=2;

  public int type;

  public ZHNewsItemEntity storyItemModel;

  public ObservableList<ZHTopItemEntity> topStoryItemModel =new ObservableArrayList<>();

  public ItemView topStoryItemView=ItemView.of(BR.viewModel, R.layout.item_news_banner_item);


  public String data;

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public ZHNewsItemEntity getStoryItemModel() {
    return storyItemModel;
  }

  public void setStoryItemModel(ZHNewsItemEntity storyItemModel) {
    this.storyItemModel = storyItemModel;
  }

  public ObservableList<ZHTopItemEntity> getTopStoryItemModel() {
    return topStoryItemModel;
  }

  public void setTopStoryItemModel(
      ObservableList<ZHTopItemEntity> topStoryItemModel) {
    this.topStoryItemModel = topStoryItemModel;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public void onItemClick(View view){
    Intent intent = new Intent(view.getContext(), NewsDetailActivity.class);
    Bundle bundle=new Bundle();
    bundle.putString(ExtraKey.base_key,String.valueOf(storyItemModel.getId()));
    intent.putExtras(bundle);
    view.getContext().startActivity(intent);
  }
}
