package org.quanqi.argon.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

import org.quanqi.argon.R;

/**
 * By jingquanqi on 11/28/13.
 */
public class AutoShowHide {
    AnimatorSet animatorSet;

    public AutoShowHide(Context context, int animID, final View target){
        animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, animID);
        animatorSet.setTarget(target);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                target.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                target.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    public void start() {
        animatorSet.start();
    }

    public void cancel() {
        animatorSet.cancel();
        animatorSet = null;
    }

    static public AutoShowHide create(Context context, View target){
        return new AutoShowHide(context, R.animator.auto_show_hide, target);
    }
}
