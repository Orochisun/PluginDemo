package cn.nutch.plugindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzh.compiler.parceler.Parceler;
import com.lzh.compiler.parceler.annotation.Arg;
import com.lzh.nonview.router.anno.RouterRule;


@RouterRule("main")
public class MainActivity extends AppCompatActivity {

    @Arg
    private String arg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parceler.toEntity(this, getIntent());
        setContentView(R.layout.activity_main);
    }
}
