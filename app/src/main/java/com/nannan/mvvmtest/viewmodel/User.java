package com.nannan.mvvmtest.viewmodel;

/**
 * @author ljnjiannan
 * @since 16/7/25.
 */
public class User {

  private String name;

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
