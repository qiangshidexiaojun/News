package com.example.news;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.example.news.Guide.GuideActivity;

/**
 * Created by Anonymous on 2016/3/25.
 */
public class TransitionActivity extends Activity {

    boolean isFirstIn = false;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.transition_view);

        final SharedPreferences sharedPreferences = getSharedPreferences("is_first_in_data",MODE_PRIVATE);
        isFirstIn = sharedPreferences.getBoolean("isFirstIn",true);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (isFirstIn) {
//                    Toast.makeText(TransitionActivity.this, "First log", Toast.LENGTH_SHORT).show();
                    intent = new Intent(TransitionActivity.this, GuideActivity.class);
                    TransitionActivity.this.startActivity(intent);
                    TransitionActivity.this.finish();
                } else {
                    intent = new Intent(TransitionActivity.this, MainActivity.class);
                    TransitionActivity.this.startActivity(intent);
                    TransitionActivity.this.finish();
                }
            }
        }, 2000);




    }

}
