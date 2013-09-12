package org.quanqi.argon.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

import org.quanqi.argon.R;

/**
 * Created by Argon on 13-9-11.
 */
public class BreathAnimation {
    AnimatorSet mSet;

    public BreathAnimation(Context ctx, int animRid, Object target) {
        mSet = (AnimatorSet) AnimatorInflater.loadAnimator(ctx, animRid);
        mSet.setTarget(target);

        mSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            // TODO
            @Override
            public void onAnimationEnd(Animator animation) {
                // TODO
                mSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
            // TODO
        });
    }

    public void start() {
        mSet.start();
    }

    public void cancel() {
        mSet.cancel();
        mSet = null;
    }

    public static BreathAnimation create(Context context, View v) {

        return new BreathAnimation(context, R.anim.anim_breath,v);
    }
}
