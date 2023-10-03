package com.example;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wefika.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FlowLayout mFlowLayout;
    private List<Keyword> mListKeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlowLayout.findViewById(R.id.flow_layout);
        initData();
        setData();
    }

    private void initData() {
        mListKeyword = new ArrayList<>();
        mListKeyword.add(new Keyword(1, "cuong"));
        mListKeyword.add(new Keyword(2, "nguyen"));
        mListKeyword.add(new Keyword(3, "huu"));
    }

    private void setData() {
        if (mFlowLayout == null) {
            return;
        }
        mFlowLayout.removeAllViews();
        if (mListKeyword != null && mListKeyword.size() > 0) {
            for (int i = 0; i < mListKeyword.size(); i++) {
                Keyword keyword = mListKeyword.get(i);
                TextView textView = new TextView(this);
                FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(0, 10, 20, 10);
                textView.setLayoutParams(params);
                textView.setId(keyword.getId());
                textView.setText(keyword.getName());
                textView.setPadding(30, 10, 30, 10);
                textView.setBackgroundResource(R.drawable.custom_layout_item);
                textView.setTextColor(getResources().getColor(com.google.android.material.R.color.material_dynamic_primary10));

                //set listener
                textView.setOnClickListener(this);

                mFlowLayout.addView(textView);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case 1:
                Toast.makeText(this, "Click item 1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Click item 2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Click item 3", Toast.LENGTH_SHORT).show();
        }
    }
}