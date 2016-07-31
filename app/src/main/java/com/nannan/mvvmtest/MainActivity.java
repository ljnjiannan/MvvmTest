package com.nannan.mvvmtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.nannan.mvvmtest.databinding.ActivityMainBinding;
import com.nannan.mvvmtest.fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    initView();
  }

  private void initView(){
    Fragment fragment=new RecyclerViewFragment();
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.content, fragment)
        .commit();
  }

}
