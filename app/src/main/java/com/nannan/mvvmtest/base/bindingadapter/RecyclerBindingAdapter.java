package com.nannan.mvvmtest.base.bindingadapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nannan.mvvmtest.base.command.ActionCommand;

import java.util.concurrent.TimeUnit;

import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * @author ljnjiannan
 * @since 16/8/5.
 */

public class RecyclerBindingAdapter {

  @BindingAdapter({"onLoadMoreCommand"})
  public static void onLoadMore(final RecyclerView recyclerView, final ActionCommand<Integer> onLoadMoreCommand) {
    RecyclerView.OnScrollListener listener = new OnScrollListener(onLoadMoreCommand);
    recyclerView.addOnScrollListener(listener);

  }


  public static class OnScrollListener extends RecyclerView.OnScrollListener {

    private PublishSubject<Integer> methodInvoke = PublishSubject.create();

    private ActionCommand<Integer> onLoadMoreCommand;

    public OnScrollListener(final ActionCommand<Integer> onLoadMoreCommand) {
      this.onLoadMoreCommand = onLoadMoreCommand;
      methodInvoke.throttleFirst(1, TimeUnit.SECONDS)
          //.subscribe(c -> onLoadMoreCommand.execute(c));
      .subscribe(new Action1<Integer>() {
        @Override
        public void call(Integer integer) {
          onLoadMoreCommand.execute(integer);
        }
      });
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
      LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
      int visibleItemCount = layoutManager.getChildCount();
      int totalItemCount = layoutManager.getItemCount();
      int pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();
      if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
        if (onLoadMoreCommand != null) {
          methodInvoke.onNext(recyclerView.getAdapter().getItemCount());
        }
      }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
      super.onScrollStateChanged(recyclerView, newState);
    }


  }
}
