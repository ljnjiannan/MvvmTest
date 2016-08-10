package com.nannan.mvvmtest.base.fragment;

import android.databinding.ViewDataBinding;

import com.nannan.mvvmtest.BR;
import com.nannan.mvvmtest.R;
import com.nannan.mvvmtest.base.vm.BaseViewModel;

/**
 * @author ljnjiannan
 * @since 16/8/2.
 */
public abstract class BaseRefreshFragment extends BaseFragment{

  @Override
  protected int getLayoutResource() {
    return R.layout.frag_base_refresh_recyclerview;
  }

  @Override
  protected void setVariable(ViewDataBinding binding) {
    binding.setVariable(BR.viewModel,getViewModel());
  }

  protected abstract BaseViewModel getViewModel();
}
