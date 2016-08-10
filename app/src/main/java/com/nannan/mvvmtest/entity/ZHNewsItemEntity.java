package com.nannan.mvvmtest.entity;

import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import com.google.gson.annotations.SerializedName;
import com.nannan.mvvmtest.base.entity.BaseEntity;

import java.util.List;

/**
 * @author ljnjiannan
 * @since 16/8/2.
 * 新闻Entity
 */
public class ZHNewsItemEntity extends BaseEntity {

  /**
   * title : 中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）
   * ga_prefix : 052321
   * images : ["http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"]
   * type : 0
   * id : 3930445
   */
  @Bindable
  @SerializedName("title")
  private String title;

  @SerializedName("ga_prefix")
  private String gaPrefix;

  @SerializedName("type")
  private int type;

  @SerializedName("id")
  private int id;

  @SerializedName("images")
  private List<String> images;

  public ZHNewsItemEntity() {
  }

  public String getTitle() { return title;}

  public void setTitle(String title) { this.title = title;}

  public String getGaPrefix() { return gaPrefix;}

  public void setGaPrefix(String gaPrefix) { this.gaPrefix = gaPrefix;}

  public int getType() { return type;}

  public void setType(int type) { this.type = type;}

  public int getId() { return id;}

  public void setId(int id) { this.id = id;}

  public List<String> getImages() { return images;}

  public void setImages(List<String> images) { this.images = images;}

  public void onItemClick(View view){
    Log.i("logtest","click"+getTitle());
  }

}
