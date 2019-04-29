package cn.nutch.plugindemo;

import android.app.Application;

import com.lzh.nonview.router.anno.RouteConfig;
import com.lzh.router.RouterRuleCreator;

import cn.nutch.replugin.starter.Starter;

/**
 * ##:3 添加路由协议, 路由协议需要到平台创建添加，具有唯一性，不能与平台现有的协议重复
 *    开发时可以自定义。
 */
@RouteConfig(baseUrl = BuildConfig.pluginAliasName + "://")
public class DemoApp extends Application {

    /**
     * appKey and appSecret is useful when read data from platform backend server.
     * @appKey
     * @appSecret
     *  这个两个值来自于在平台中创建的APP中，且是平台自动生成的
     *  appKey创建后不能更改，appSecret只能重置，不能手动修改
     *  这两个值只用于当插件要读取后台一些配置信息的时候有用，缺省可以不需要
     */

    private static String appKey = "Your app key";
    private static String appSecret = "Your app secret";

    public void onCreate() {
        super.onCreate();

        /**
         * ##:4 初始化插件信息
         *    RouterRuleCreator 为自动生成的 class.
         *    编译未生成时，可先注释掉下面的行，避免编译出错
         */
        Starter.init(this, new RouterRuleCreator(), appKey, appSecret);
    }

}
