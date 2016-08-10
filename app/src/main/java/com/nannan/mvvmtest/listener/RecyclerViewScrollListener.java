package com.nannan.mvvmtest.listener;

import android.support.v7.widget.RecyclerView;

import rx.subjects.PublishSubject;

/**
 * @author ljnjiannan
 * @since 16/8/4.
 */
public class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {

  private PublishSubject<Integer> methodInvoke = PublishSubject.create();

  //private ReplyCommand<Integer> onLoadMoreCommand;

  //public RecyclerViewScrollListener(Action1<Integer> ) {
  //  //this.onLoadMoreCommand = onLoadMoreCommand;
  //  //methodInvoke.throttleFirst(1, TimeUnit.SECONDS)
  //  //    .subscribe(c -> onLoadMoreCommand.execute(c));
  //  //methodInvoke.throttleFirst(1,TimeUnit.SECONDS)
  //
  //}

  //@Override
  //public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
  //  LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
  //  int visibleItemCount = layoutManager.getChildCount();
  //  int totalItemCount = layoutManager.getItemCount();
  //  int pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();
  //  if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
  //    if (onLoadMoreCommand != null) {
  //      methodInvoke.onNext(recyclerView.getAdapter().getItemCount());
  //    }
  //  }
  //}
  //
  //@Override
  //public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
  //  super.onScrollStateChanged(recyclerView, newState);
  //}
}
