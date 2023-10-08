package com.example.butterknife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnn_1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnn_1, R.id.btnn_2})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnn_1:
                Toast.makeText(this, "Button 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnn_2:
                Toast.makeText(this, "Button 2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}