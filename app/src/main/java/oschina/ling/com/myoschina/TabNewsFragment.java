package oschina.ling.com.myoschina;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import oschina.ling.com.myoschina.base.BasePageFragment;
import oschina.ling.com.myoschina.base.BasePagerAdapter;


/**
 * 综合fragment
 */
public class TabNewsFragment extends BasePageFragment {

    @Override
    protected void addPager(BasePagerAdapter adapter) {
        String[] titleArray = getResources().getStringArray(R.array.news_viewpage_arrays);
        for (int i = 0; i < titleArray.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("title", titleArray[i]);
            BlankFragment blankFragment = new BlankFragment();
            blankFragment.setArguments(bundle);
            adapter.addPagerFragment(titleArray[i], blankFragment);
        }
    }
}
