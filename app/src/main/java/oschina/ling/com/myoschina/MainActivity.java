package oschina.ling.com.myoschina;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import oschina.ling.com.myoschina.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabhost;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initActionBar();
        initTab();
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.app_name));
        actionBar.setLogo(getResources().getDrawable(R.drawable.ic_drawer));
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
            }
            //设置Tab按钮之间的分割线  设为透明 
            mTabhost.getTabWidget().setDividerDrawable(getResources().getDrawable(android.R.color.transparent));
            tabSpec.setIndicator(tabView);
            mTabhost.addTab(tabSpec, mainTab.getClz(), null);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
