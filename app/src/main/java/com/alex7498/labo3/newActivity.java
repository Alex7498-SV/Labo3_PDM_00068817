package com.alex7498.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alex7498.labo3.Utils.AppConstants;

public class newActivity extends AppCompatActivity {

    private TextView mUser, mPass, mEmail, mGenero;
    private Button mShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        mUser = findViewById(R.id.userText);
        mPass = findViewById(R.id.passText);
        mEmail = findViewById(R.id.emailText);
        mGenero = findViewById(R.id.generoText);
        mShare = findViewById(R.id.share);
        Intent mIntent = this.getIntent();

        if(mIntent != null){
            String[] text = mIntent.getStringArrayExtra(AppConstants.T1);
            mUser.setText(text[0]);
            mPass.setText(text[1]);
            mEmail.setText(text[2]);
            mGenero.setText(text[3]);

            mShare.setOnClickListener(e->{
                Intent mIntent2 = new Intent();
                mIntent2.setAction(Intent.ACTION_SEND);
                mIntent2.setType("text/plain");
                mIntent2.putExtra(Intent.EXTRA_TEXT, text[0]+text[1]+text[2]+text[3]);
                startActivity(mIntent2);
            });
        }
    }
}
