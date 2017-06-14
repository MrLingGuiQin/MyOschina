package oschina.ling.com.myoschina.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import oschina.ling.com.myoschina.R;

/**
 * ***************************************
 * statement: 封装Viewpage fragment
 * auther: lingguiqin
 * date created : 2017/6/14 0014
 * ***************************************
 */

public abstract class BasePageFragment extends Fragment {

    @BindView(R.id.vpi_base_page_title)
    TitlePageIndicator mVpiBasePageTitle;
    @BindView(R.id.vp_base_page)
    ViewPager mVpBasePage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basepage, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    /**
     * 界面初始化完成时的回调
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // fragment 嵌套 goole建议 使用 getChildFragmentManager
        BasePagerAdapter adapter = new BasePagerAdapter(getChildFragmentManager());
        addPager(adapter);
        mVpBasePage.setAdapter(adapter);
        mVpiBasePageTitle.setViewPager(mVpBasePage);
    }

    protected abstract void addPager(BasePagerAdapter adapter);
}
