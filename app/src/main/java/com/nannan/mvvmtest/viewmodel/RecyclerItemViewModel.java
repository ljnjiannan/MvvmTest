package com.nannan.mvvmtest.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

/**
 * @author ljnjiannan
 * @since 16/7/28.
 */
public class RecyclerItemViewModel extends BaseObservable {

  private Context mContext;
  @Bindable
  private String title;

  public RecyclerItemViewModel(Context mContext) {
    this.mContext = mContext;
  }

  public RecyclerItemViewModel(Context mContext, String title) {
    this.mContext = mContext;
    this.title = title;
  }

  public void onItemClick(View v){
    Toast.makeText(mContext, title, Toast.LENGTH_SHORT).show();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
