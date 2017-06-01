package com.ydtx.lastofmonthtest;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ydtx.lastofmonthtest.frame.Zhutiribao;
import com.ydtx.lastofmonthtest.frame.Zuixinribao;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();//加载控件
        addTabTitle();//TabLayout添加Title
        Zuixinribao zuixinribao = new Zuixinribao();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,zuixinribao).commit();
    }

    private void addTabTitle() {
        tab.addTab(tab.newTab().setText("最新日报"));
        tab.addTab(tab.newTab().setText("专栏"));
        tab.addTab(tab.newTab().setText("热门"));
        tab.addTab(tab.newTab().setText("主题日报"));

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    Zuixinribao zuixinribao = new Zuixinribao();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,zuixinribao).commit();
                }else if(tab.getPosition()==3){
                    Zhutiribao zhutiribao = new Zhutiribao();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,zhutiribao).commit();
                }
            }{
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){

                    Zuixinribao zuixinribao = new Zuixinribao();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,zuixinribao).commit();
                }else if(tab.getPosition()==3){
                    Toast.makeText(MainActivity.this, "主题日报", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {

        tab = (TabLayout) findViewById(R.id.main_tab);//TabLayout
        frame = (FrameLayout) findViewById(R.id.main_frame);//FrameLayout

    }
}
