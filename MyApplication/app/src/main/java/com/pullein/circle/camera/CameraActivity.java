package com.pullein.circle.camera;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pullein.circle.R;
import com.pullein.circle.activity.BaseActivity;

/**
 * Created by Administrator on 2017/6/9.
 */

public class CameraActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleBar(false);
        setContentView(R.layout.activity_camera);
    }
}
