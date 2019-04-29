package cn.nutch.plugindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lzh.compiler.parceler.Parceler;
import com.lzh.compiler.parceler.annotation.Arg;
import com.lzh.nonview.router.anno.RouterRule;

/**
 * ##:5 添加路由入口，该值用于路由框架注册和发现该activity，host就就是通过该入口启动activity的
 * 这也是插件的入口，没有这个，Host将不知道如何启动插件
 * 插件入口需要定义至少一个，也可以无限多个。总之，只要告诉 Host 一个启动地址就可以了
 * <p>
 * 为避免不必要的兼容问题，统一规定所有的插件activity需继承：AppCompatActivity
 */
@RouterRule("main")
public class MainActivity extends AppCompatActivity {

    /**
     * 插件在通过路由方式进行访问是可以携带参数，参数名称和参数个数没有限制，自定义接收
     * <p>
     * 如：demo://main?arg=hello&arg1=world
     * <p>
     * 在 onCreate 中调用 ：Parceler.toEntity(this, getIntent());
     * 参数值将被自动注入进来，不需要添加其他代码
     * 参数仅支持字符串形式
     */
    @Arg
    private String arg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 下面这行是解析参数值的调用方式
         * 通过调用下面的方法，参数将自动获取
         */
        Parceler.toEntity(this, getIntent());

        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        if (null != textView & null != arg) {
            textView.setText(arg);
        }
    }
}
