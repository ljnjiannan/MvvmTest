package com.nannan.mvvmtest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nannan.mvvmtest.databinding.RecyclerViewFragmentBinding;
import com.nannan.mvvmtest.viewmodel.ViewModel;

/**
 * @author ljnjiannan
 * @since 16/7/30.
 */
public class RecyclerViewFragment extends Fragment {

  private static final String Tag = "RecyclerViewFragment";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    RecyclerViewFragmentBinding binding = RecyclerViewFragmentBinding
        .inflate(inflater, container, false);
    binding.setViewModel(new ViewModel(getActivity()));
    return binding.getRoot();
  }
}
