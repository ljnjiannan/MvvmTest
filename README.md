# MvvmTest
An Android Project of MVVM Mode
###构建MVVM模式的基本应用框架笔记 序
####零、废话
　　最近不知道为什么，在各种各样的地方都能看到MVVM设计模式，不管是ios开发相关还是Android开发相关的文章到处可见MVVM的踪影，于是乎决定与懒癌进行一番殊死搏斗，用MVVM模式来开发个框架，并尝试着做些什么出来，顺便记录下制作的过程，且行且记录。
　　
####一、什么是MVVM
　　据说是一种很屌的设计模式，和早已火过的MVC和MVP相比，具有更低的耦合性，更好的复用性，并且不需要写过多的接口。很多帖子里对各种设计模式有很详细的对比，我没有抄袭的习惯，就不去搬运了。其实吧，从伪哲学的角度来说呢，MVVM、MVP和MVC这些模式其实就是一种思维模式，选择最适合自己的思维模式才是王道！当然，作为一名合格的程序员，不断的折腾新的知识是基本素质。
　　
####二、准备工作
因为Android中的MVVM是以dataBinding为基础的，所以首先要搞清楚什么是dataBinding。

献上[Data Binding Library](https://developer.android.com/topic/libraries/data-binding/index.html)官网（谷歌地址，量力而行）

什么是Data Binding呢？简单从字面上看就是绑定数据啦。然而是要把谁和数据捆绑在一起呢？基本上可以理解成是把View和Data绑定，合体变成了ViewModel，也就行程了MVVM中的VM。当然，这样理解肯定是有一些问题的，但是为了快速产生一个好的印象，不妨先这样理解着。

官方要求：
* Android platform versions Android 2.1 (API level 7+)以上
* Gradle Plugin 1.5.0-alpha1以上
　　
然后就是谷歌爸爸亲自教育我们构建dataBinding环境的方法啦！
![](http://oawnlw8zg.bkt.clouddn.com/14694614808850.jpg)
在你需要使用dataBinding的module中的build.gradle中添加代码

```
dataBinding {
        enabled = true
    }
```

现在先去简单的验证下dataBinding的效果吧！
打开新建的项目中MainActivity的布局文件，给布局文件添加一个 `layout` 根节点，把原来的布局文件放在根节点中，并且加上 `data` 元素，`data`元素的内容就是Model。`data`元素中使用 `variable`元素来设置变量，其中的 `name`字段设置变量名，type字段设置变量的类。
然后把原先的布局也放到 `layout`根节点中，现在布局的xml文件中就包含了data和view，并且data变量可以直接在xml中使用哦，例如给TextView设置text。

```
<layout
  xmlns:android="http://schemas.android.com/apk/res/android">

  <data>
    <variable name="user" type="com.nannan.mvvmtest.Variable.User"/>
  </data>

  <LinearLayout
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="@{user.name}"/>
  </LinearLayout>
</layout>
```

我的User类的代码


```
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

```


接下来就是到`MainActivity`中写代码啦！`onCreate`方法中唯一的代码`setContentView()`在这里就过时啦，现在要用`DataBindingUtil.setContentView()`方法来绑定布局文件而且，`DataBindingUtil.setContentView()`返回值的类是根据布局文件的名字在编译的时候自动生成的哦，例如我的布局文件名称是`activity_main`，生成的类就是`ActivityMainBinding`当然也是可以自定义一个类的。然后就是要初始化一个在布局文件中使用到的变量的对象，并且将这个变量赋值到布局文件的ViewModel中哦。

```
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    User user = new User("Test");
    binding.setUser(user);
  }
}

```

好啦，简单的dataBinding就是这样了，以后心情好的时候再详细的研究下。
接下去就是一些基类的编写啦！（待续）



