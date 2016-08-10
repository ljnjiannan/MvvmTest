package com.nannan.mvvmtest.fragment;

import com.nannan.mvvmtest.base.fragment.BaseRefreshFragment;
import com.nannan.mvvmtest.base.vm.BaseViewModel;
import com.nannan.mvvmtest.vm.ZHHomeViewModel;

/**
 * @author ljnjiannan
 * @since 16/7/30.
 */
public class RecyclerViewFragment extends BaseRefreshFragment {

  private static final String Tag = "RecyclerViewFragment";

  @Override
  protected BaseViewModel getViewModel() {
    return new ZHHomeViewModel(getActivity());
  }
}
