package com.example;

import android.Manifest;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.io.IOException;
import java.util.List;

import gun0912.tedimagepicker.builder.TedImagePicker;


public class MainActivity extends AppCompatActivity {
    Button btnSelectPhoto;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelectPhoto = findViewById(R.id.btn_select_photo);
        imageView = findViewById(R.id.image_view);
        btnSelectPhoto.setOnClickListener(view -> requestPermissions());
    }

    private void requestPermissions() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                TedImagePicker.with(MainActivity.this)
                        .start(uri -> {
                            try {
                                imageView.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), uri));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        TedPermission.create()
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(android.Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();
    }
}