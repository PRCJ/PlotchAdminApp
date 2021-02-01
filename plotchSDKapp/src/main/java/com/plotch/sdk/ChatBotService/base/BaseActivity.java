package com.plotch.sdk.ChatBotService.base;

import android.net.http.HttpResponseCache;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.plotch.sdk.ChatBotService.view_element.CustomProgressDialogFragment;
import com.plotch.sdk.R;
import com.plotch.sdk.network.NetworkUtil;
import com.plotch.sdk.utils.ViewUtil;


public abstract class BaseActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {
    private P mPresenter;

    protected void showProgressLoader(String message) {
        CustomProgressDialogFragment userInfoDialogFragment = new CustomProgressDialogFragment().newInstance();
        userInfoDialogFragment.show(getSupportFragmentManager(), CustomProgressDialogFragment.TAG);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    protected void hideProgressLoader() {
        Fragment prev = getSupportFragmentManager().findFragmentByTag(CustomProgressDialogFragment.TAG);
        if (prev != null) {
            CustomProgressDialogFragment df = (CustomProgressDialogFragment) prev;
            df.dismiss();
        }
    }

    protected abstract void setUpViews();

    protected abstract P createPresenter();

    protected abstract int getLayout();

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        mPresenter.attachView(this);
        setUI();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        cleareHttpCash();
        super.onDestroy();
    }

    protected void setUI() {
        setUpViews();
    }

    @Override
    public boolean isNetworkAvailable() {
        return NetworkUtil.isNetworkAvailable(this, false);
    }

    // MvpView Methods
    @Override
    public boolean isNetworkAvailable(boolean showMsg) {
        return NetworkUtil.isNetworkAvailable(this, true);
    }

    @Override
    public void showLoadingIndicator() {
        showLoadingIndicator(R.string.text_common_loading);
    }

    @Override
    public void showLoadingIndicator(@StringRes int msgResId) {
        showLoadingIndicator(getString(msgResId));
    }

    @Override
    public void showLoadingIndicator(String loadingMsg) {
        showProgressLoader(loadingMsg);
    }

    @Override
    public void hideLoadingIndicator() {
        hideProgressLoader();
    }

    // Screen Related Functions
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            View view = getCurrentFocus();
            if (view != null && view instanceof EditText) {
                ViewUtil.hideKeyboard(this);
            }
        } catch (Exception e) {
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ViewUtil.hideKeyboard(this);
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void cleareHttpCash() {

        HttpResponseCache cache = HttpResponseCache.getInstalled();
        if (cache != null) {
            cache.flush();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public boolean isAlive() {
        return !isFinishing() && !isDestroyed();
    }

}
