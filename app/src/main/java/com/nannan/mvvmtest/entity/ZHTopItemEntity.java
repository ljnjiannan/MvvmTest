package com.nannan.mvvmtest.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author ljnjiannan
 * @since 16/8/2.
 * 顶部轮播图Entity
 */
public class ZHTopItemEntity {

  /**
   * title : 商场和很多人家里，竹制家具越来越多（多图）
   * image : http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg
   * ga_prefix : 052315
   * type : 0
   * id : 3930883
   */

  @SerializedName("title") private String title;
  @SerializedName("image") private String image;
  @SerializedName("ga_prefix") private String gaPrefix;
  @SerializedName("type") private int type;
  @SerializedName("id") private int id;

  public String getTitle() { return title;}

  public void setTitle(String title) { this.title = title;}

  public String getImage() { return image;}

  public void setImage(String image) { this.image = image;}

  public String getGaPrefix() { return gaPrefix;}

  public void setGaPrefix(String gaPrefix) { this.gaPrefix = gaPrefix;}

  public int getType() { return type;}

  public void setType(int type) { this.type = type;}

  public int getId() { return id;}

  public void setId(int id) { this.id = id;}
}
