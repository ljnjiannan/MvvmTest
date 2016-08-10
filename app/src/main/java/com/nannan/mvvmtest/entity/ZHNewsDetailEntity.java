package com.nannan.mvvmtest.entity;

import com.google.gson.annotations.SerializedName;
import com.nannan.mvvmtest.base.entity.BaseEntity;

import java.util.List;

/**
 * @author ljnjiannan
 * @since 16/8/10.
 */

public class ZHNewsDetailEntity extends BaseEntity{

  /**
   * body : das
   * image_source : 版权图片库
   * title : 深夜惊奇 · 朋友圈错觉
   * image : http://pic3.zhimg.com/2d41a1d1ebf37fb699795e78db76b5c2.jpg
   * share_url : http://daily.zhihu.com/story/4772126
   * js : []
   * recommenders : [{"avatar":"aaa"},{"avatar":"aaa"},{"avatar":"http://pic4.zhimg.com/e6637a38d22475432c76e6c9e46336fb_m.jpg"},{"avatar":"http://pic1.zhimg.com/bd751e76463e94aa10c7ed2529738314_m.jpg"},{"avatar":"http://pic1.zhimg.com/4766e0648_m.jpg"}]
   * ga_prefix : 050615
   * section : {"thumbnail":"http://pic4.zhimg.com/6a1ddebda9e8899811c4c169b92c35b3.jpg","id":1,"name":"深夜惊奇"}
   * type : 0
   * id : 4772126
   * css : ["http://news.at.zhihu.com/css/news_qa.auto.css?v=1edab"]
   */

  @SerializedName("body") private String body;
  @SerializedName("image_source") private String imageSource;
  @SerializedName("title") private String title;
  @SerializedName("image") private String image;
  @SerializedName("share_url") private String shareUrl;
  @SerializedName("ga_prefix") private String gaPrefix;
  /**
   * thumbnail : http://pic4.zhimg.com/6a1ddebda9e8899811c4c169b92c35b3.jpg
   * id : 1
   * name : 深夜惊奇
   */

  @SerializedName("section") private SectionBean section;
  @SerializedName("type") private int type;
  @SerializedName("id") private int id;
  @SerializedName("js") private List<?> js;
  /**
   * avatar : aaa
   */

  @SerializedName("recommenders") private List<RecommendersBean> recommenders;
  @SerializedName("css") private List<String> css;

  public String getBody() { return body;}

  public void setBody(String body) { this.body = body;}

  public String getImageSource() { return imageSource;}

  public void setImageSource(String imageSource) { this.imageSource = imageSource;}

  public String getTitle() { return title;}

  public void setTitle(String title) { this.title = title;}

  public String getImage() { return image;}

  public void setImage(String image) { this.image = image;}

  public String getShareUrl() { return shareUrl;}

  public void setShareUrl(String shareUrl) { this.shareUrl = shareUrl;}

  public String getGaPrefix() { return gaPrefix;}

  public void setGaPrefix(String gaPrefix) { this.gaPrefix = gaPrefix;}

  public SectionBean getSection() { return section;}

  public void setSection(SectionBean section) { this.section = section;}

  public int getType() { return type;}

  public void setType(int type) { this.type = type;}

  public int getId() { return id;}

  public void setId(int id) { this.id = id;}

  public List<?> getJs() { return js;}

  public void setJs(List<?> js) { this.js = js;}

  public List<RecommendersBean> getRecommenders() { return recommenders;}

  public void setRecommenders(
      List<RecommendersBean> recommenders) { this.recommenders = recommenders;}

  public List<String> getCss() { return css;}

  public void setCss(List<String> css) { this.css = css;}

  public static class SectionBean {
    @SerializedName("thumbnail") private String thumbnail;
    @SerializedName("id") private int id;
    @SerializedName("name") private String name;

    public String getThumbnail() { return thumbnail;}

    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail;}

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}
  }

  public static class RecommendersBean {
    @SerializedName("avatar") private String avatar;

    public String getAvatar() { return avatar;}

    public void setAvatar(String avatar) { this.avatar = avatar;}
  }
}
