package com.nannan.mvvmtest.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nannan.mvvmtest.R;
import com.nannan.mvvmtest.conf.ExtraKey;
import com.nannan.mvvmtest.databinding.ActivityNewsDetailBinding;
import com.nannan.mvvmtest.vm.ZHNewsDetailViewModel;

/**
 * @author ljnjiannan
 * @since 16/8/10.
 */

public class NewsDetailActivity extends AppCompatActivity {

  private String storyId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getExtra();
    ActivityNewsDetailBinding dataBindinng= DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
    dataBindinng.setViewModel(new ZHNewsDetailViewModel(storyId));
  }

  private void getExtra(){
    storyId=getIntent().getExtras().getString(ExtraKey.base_key);
  }
}
