package com.pullein.circle.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pullein.circle.R;

/**
 * Created by xugang on 2017/6/8.
 */

public class BaseActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    private
    @MenuRes
    int mMenuRes = -1;
    private boolean isTitleBar = true;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(LayoutInflater.from(this).inflate(layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, null);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().setContentView(isTitleBar ? LayoutInflater.from(this).inflate(R.layout.activity_parent, null) : view);
        LinearLayout parent = (LinearLayout) findViewById(R.id.parent);
        if (parent == null) return;
        if (params != null)
            view.setLayoutParams(params);
        parent.addView(view);
    }


    protected  <T extends View> T getView(@IdRes int id) {
        return (T) findViewById(id);
    }

    public void setTitleBar(boolean titleBar) {
        isTitleBar = titleBar;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initTitleToolBar();
    }

    private void initTitleToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_action_back);
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(v -> finish());
            toolbar.setOnMenuItemClickListener(this);
        }
    }

    public void setMenuRes(int mMenuRes) {
        this.mMenuRes = mMenuRes;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (-1 != mMenuRes) {
            getMenuInflater().inflate(mMenuRes, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
