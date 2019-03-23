package com.alex7498.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    private TextView mTextV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        mTextV2 = findViewById(R.id.TextV2);

        Intent mIntent = getIntent();

        if (mIntent!=null) {
            mTextV2.setText(mIntent.getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}
