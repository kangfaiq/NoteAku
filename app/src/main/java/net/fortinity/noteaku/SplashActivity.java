package net.fortinity.noteaku;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    ImageView bgapp, clover;
    TextView say_good, say_name;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bgapp = findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover_splash);
        say_good = findViewById(R.id.say_good);
        say_name = findViewById(R.id.say_name);

        bgapp.animate().translationY(-2250).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(500).setStartDelay(600);
        say_good.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);
        say_name.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 1200);
    }
}
