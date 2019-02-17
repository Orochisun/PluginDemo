package cn.nutch.plugindemo;

import android.app.Application;

import com.lzh.nonview.router.anno.RouteConfig;
import com.lzh.router.RouterRuleCreator;

import cn.nutch.replugin.starter.Starter;

@RouteConfig(baseUrl = BuildConfig.pluginAliasName + "://")
public class DemoApp extends Application {
    public void onCreate() {
        super.onCreate();
        Starter.init(this, new RouterRuleCreator());
    }

}
