package com.nannan.mvvmtest.base.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author ljnjiannan
 * @since 16/8/1.
 */
public abstract class BaseFragment extends Fragment{

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater
        .from(container.getContext()),getLayoutResource(), container, false);
    setVariable(binding);
    return binding.getRoot();
  }

  protected abstract int getLayoutResource();

  protected abstract void setVariable(ViewDataBinding binding);

}
