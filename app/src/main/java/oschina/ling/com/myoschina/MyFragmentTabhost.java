package oschina.ling.com.myoschina;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2017/6/7.
 * 定制FragmentTabhost
 */

public class MyFragmentTabhost extends FragmentTabHost {
    private String mCurrentTabId;

    private String mNoChangeTabId;


    public MyFragmentTabhost(Context context) {
        super(context);
    }

    public MyFragmentTabhost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // tab点击切换回调监听
    @Override
    public void onTabChanged(String tabId) {
        if (tabId.equals(mNoChangeTabId)) {
            setCurrentTabByTag(mCurrentTabId);
            return;
        }
        super.onTabChanged(tabId);
        mCurrentTabId = tabId;
    }

    public void setNoChangeTabId(String noChangeTabId) {
        mNoChangeTabId = noChangeTabId;
    }

}
