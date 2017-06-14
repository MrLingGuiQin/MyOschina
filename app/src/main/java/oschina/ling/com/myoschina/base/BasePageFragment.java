package oschina.ling.com.myoschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import oschina.ling.com.myoschina.R;

/**
 * ***************************************
 * statement: 封装Viewpage fragment
 * auther: lingguiqin
 * date created : 2017/6/14 0014
 * ***************************************
 */

public class BasePageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basepage, container);
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
        super.onViewCreated(view, savedInstanceState);


    }
}
