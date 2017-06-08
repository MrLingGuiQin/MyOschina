package oschina.ling.com.myoschina.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * ***************************************
 * statement:
 * auther: lingguiqin
 * date created : 2017/2/26 0026
 * ***************************************
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public Context mContext;
    public ProgressDialog mProgressDialog;
    public final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        int layoutResId = getLayoutResId();
        if (layoutResId != 0) {
            setContentView(layoutResId);
        }
        ButterKnife.bind(this);
        initData();
        initView(savedInstanceState);
    }

    public abstract int getLayoutResId();

    public void initData() {
    }

    public abstract void initView(Bundle savedInstanceState);

    public void showToast(String msg, int duration) {
        Toast.makeText(this, msg, duration).show();
    }

    public void showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
        }
        mProgressDialog.setMessage("正在加载...");
        mProgressDialog.show();

    }

    public void dismisProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }

    }


    /**
     * 跳转到指定Activity
     *
     * @param cls 指定跳转的activity
     **/
    public void goToCustomActivity(Class<?> cls) {
        Intent intent = new Intent(mContext, cls);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }

}
