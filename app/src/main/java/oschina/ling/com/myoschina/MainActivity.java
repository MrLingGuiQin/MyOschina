package oschina.ling.com.myoschina;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import butterknife.BindView;
import oschina.ling.com.myoschina.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @BindView(android.R.id.tabhost)
    MyFragmentTabhost mTabhost;
    @BindView(R.id.tb_toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initToolbar();
        initTab();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_drawer);
        mToolbar.setTitle(getString(R.string.app_name));
        mToolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("666", 1);
            }
        });
    }

    private void initTab() {
        mTabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        MainTab[] tabs = MainTab.values();
        for (int i = 0; i < tabs.length; i++) {
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(mainTab.getResName()));
            View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_tab, null);
            TextView textView = (TextView) tabView.findViewById(R.id.txt_tab_item);
            textView.setText(mainTab.getResName());
            textView.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(mainTab.getResIcon()), null, null);
            if (i == 2) {
                tabView.setVisibility(View.INVISIBLE);
                mTabhost.setNoChangeTabId(getString(mainTab.getResName()));
            }
            //设置Tab按钮之间的分割线  设为透明 
            mTabhost.getTabWidget().setDividerDrawable(getResources().getDrawable(android.R.color.transparent));
            tabSpec.setIndicator(tabView);
            mTabhost.addTab(tabSpec, mainTab.getClz(), null);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }


    // 设置菜单按钮点击时间
    private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_search:
                    showToast("开始搜索啦啦啦---", 1);
                    break;
            }
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
