package com.pullein.circle;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.pullein.circle.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMenuRes(R.menu.main);
    }

    AlertDialog dialog;

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (R.id.camera == item.getItemId()) {
            dialog = new AlertDialog.Builder(this)
                    .setView(R.layout.layout_dialog_camera)
                    .create();
            dialog.show();
        }
        return true;
    }

    public void onDialogItemClick(View view) {
        if (dialog != null)
            dialog.cancel();
        switch (view.getId()) {
            case R.id.openAlum:
                Toast.makeText(this, "1111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.openCamera:
                Toast.makeText(this, "2222", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
