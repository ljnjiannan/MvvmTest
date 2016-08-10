package com.nannan.mvvmtest.entity;

import com.google.gson.annotations.SerializedName;
import com.nannan.mvvmtest.base.entity.BaseEntity;

import java.util.List;

/**
 * @author ljnjiannan
 * @since 16/8/2.
 */
public class ZHHomeEntity extends BaseEntity {

  @SerializedName("stories")
  public List<ZHNewsItemEntity> stories;
  @SerializedName("top_stories")
  public List<ZHTopItemEntity> topStories;
  @SerializedName("date")
  public String date;

  public List<ZHNewsItemEntity> getStories() {
    return stories;
  }

  public void setStories(List<ZHNewsItemEntity> stories) {
    this.stories = stories;
  }

  public List<ZHTopItemEntity> getTopStories() {
    return topStories;
  }

  public void setTopStories(
      List<ZHTopItemEntity> topStories) {
    this.topStories = topStories;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
