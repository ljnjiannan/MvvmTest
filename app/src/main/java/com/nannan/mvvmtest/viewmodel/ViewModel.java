package com.nannan.mvvmtest.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.nannan.mvvmtest.BR;
import com.nannan.mvvmtest.R;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * @author ljnjiannan
 * @since 16/7/27.
 */
public class ViewModel {
  public ObservableList<RecyclerItemViewModel> items = new ObservableArrayList<>();
  public ItemView itemView= ItemView.of(BR.item, R.layout.item);

  private Context mContext;

  public ViewModel(Context context) {
    mContext=context;
    for(int i=0;i<10;i++){
      items.add(new RecyclerItemViewModel(mContext,"item "+i));
    }
  }

}
