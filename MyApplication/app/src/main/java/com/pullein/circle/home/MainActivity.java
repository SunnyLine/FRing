package com.pullein.circle.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.pullein.circle.R;
import com.pullein.circle.activity.BaseActivity;
import com.pullein.circle.album.AlbumActivity;
import com.pullein.circle.camera.CameraActivity;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMenuRes(R.menu.main);
        recyclerView = getView(R.id.recyclerView);
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
        if (dialog != null && dialog.isShowing())
            dialog.cancel();
        switch (view.getId()) {
            case R.id.openAlbum:
                startActivity(new Intent(this, AlbumActivity.class));
                break;
            case R.id.openCamera:
                startActivity(new Intent(this, CameraActivity.class));
                break;
        }
    }
}
