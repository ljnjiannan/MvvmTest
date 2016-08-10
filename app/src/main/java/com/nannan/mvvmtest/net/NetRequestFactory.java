package com.nannan.mvvmtest.net;

import com.nannan.mvvmtest.net.impl.ZHHomeServiceImpl;
import com.nannan.mvvmtest.net.service.ZHHomeService;

/**
 * @author ljnjiannan
 * @since 16/7/31.
 * 网络请求的工厂类
 */
public class NetRequestFactory {
  private static final Object LOCK = new Object();

  public static ZHHomeService sZHHomeService;

  public static ZHHomeService getsZHHomeService(){
    synchronized (LOCK){
      if(sZHHomeService==null){
        sZHHomeService=new ZHHomeServiceImpl();
      }
    }
    return sZHHomeService;
  }

}
