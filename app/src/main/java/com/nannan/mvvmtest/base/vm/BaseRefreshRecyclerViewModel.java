package com.nannan.mvvmtest.base.vm;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.v4.widget.SwipeRefreshLayout;

import com.nannan.mvvmtest.base.command.ActionCommand;

import me.tatarka.bindingcollectionadapter.BaseItemViewSelector;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.functions.Action1;

/**
 * @author ljnjiannan
 * @since 16/8/3.
 */
public abstract class BaseRefreshRecyclerViewModel<T> extends BaseViewModel{
  public static final String Tag="ZHHomeViewModel";
  public Context mContext;

  //当前已请求时间
  public String currentDate="";
  //item对应的数据
  public ObservableList<T> newsList = new ObservableArrayList<>();

  //下拉刷新状态控制
  public final ObservableBoolean isRefreshing = new ObservableBoolean(false);

  public BaseRefreshRecyclerViewModel(Context mContext) {
    this.mContext = mContext;
    initViewModel();
    initDataRequest();
  }

  public BaseRefreshRecyclerViewModel(){
    initViewModel();
    initDataRequest();
  }

  //初始化数据请求
  protected abstract void initDataRequest();


  protected abstract int getItemLayout();

  protected abstract void initViewModel();

  public SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
      isRefreshing.set(true);
      onRefreshing();
    }
  };

  //下拉刷新操作
  protected abstract void onRefreshing();

  public void onRefreshComplete(){
    isRefreshing.set(false);
  }

  //上拉加载更多
  public final ActionCommand<Integer> onLoadMoreCommand = new ActionCommand<>(new Action1<Integer>() {

    @Override
    public void call(Integer integer) {
      onLoadMore();
    }
  });

  protected abstract void onLoadMore();

  public ItemViewSelector<T> newsItemView = new BaseItemViewSelector<T>() {
    @Override
    public void select(ItemView itemView, int position, T item) {
      //itemView.set(BR.item, position == 0 ? R.layout.item_header : R.layout.item);
      //itemView.set(BR.newsItem, getItemLayout());
      setitemView(itemView,position,item);
    }

    // You need to override this method when using a ListView as it requires to know how
    // many view types there are immedeatly. RecyclerView and ViewPager don't need this.
    @Override
    public int viewTypeCount() {
      return 2;
    }
  };

  protected abstract void setitemView(ItemView itemView, int position, T item);

}
