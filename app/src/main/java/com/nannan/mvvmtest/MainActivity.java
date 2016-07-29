package com.nannan.mvvmtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nannan.mvvmtest.databinding.ActivityMainBinding;
import com.nannan.mvvmtest.viewmodel.User;
import com.nannan.mvvmtest.viewmodel.ViewModel;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    User user = new User("Test");
    binding.setUser(user);
    ViewModel viewModel=new ViewModel(this);
    binding.setViewModel(viewModel);
  }
  
}
