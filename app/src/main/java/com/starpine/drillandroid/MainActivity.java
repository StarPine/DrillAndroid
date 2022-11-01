package com.starpine.drillandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.starpine.drillandroid.annotation.InputId;
import com.starpine.drillandroid.utils.InjectionUtils;

public class MainActivity extends AppCompatActivity {

    @InputId(R.id.tv_hello)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectionUtils.injectionView(this);

        textView.setText("hkahf");
    }
}