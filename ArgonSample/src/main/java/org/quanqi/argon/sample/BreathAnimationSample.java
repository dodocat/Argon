package org.quanqi.argon.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.quanqi.argon.anim.BreathAnimation;


public class BreathAnimationSample extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breath_anim);
        View v = findViewById(R.id.imageView);
        BreathAnimation anim = BreathAnimation.create(this.getApplicationContext(), v);
        anim.start();
    }
}
