package com.example;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.cpp)
    CountryCodePicker ccp;

    @BindView(R.id.edit_phone_number)
    EditText editTextCarrierNumber;

    @BindView(R.id.img_check)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ccp.registerCarrierNumberEditText(editTextCarrierNumber);
        ccp.setPhoneNumberValidityChangeListener(isValidNumber -> {
            if (isValidNumber) imageView.setImageResource(R.drawable.pass);
            else imageView.setImageResource(R.drawable.fail);
        });
    }

    @OnTextChanged(value = {R.id.edit_phone_number}, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void addTextChangedListener() {
        if (TextUtils.isEmpty(editTextCarrierNumber.getText().toString()))
            imageView.setVisibility(View.INVISIBLE);
        else imageView.setVisibility(View.VISIBLE);
    }
}