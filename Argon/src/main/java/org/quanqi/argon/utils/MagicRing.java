package org.quanqi.argon.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/**
 * By jingquanqi on 11/20/13.
 */
public class MagicRing extends Drawable {
    private int color = Color.BLUE;
    private int radius = 150;
    private int innerRadius = 145;
    private double startRectangle;
    private double rectangle = 60;
    private Paint mPaintCircle  = new Paint();
    private RectF rectF = new RectF(5, 5, 400, 400);
    Paint paint = new Paint();
    int angle = 0;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            invalidateSelf();
        }
    };

    @Override
    public void draw(Canvas canvas) {
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        canvas.drawArc(rectF, 0, angle, false, paint);
        angle++;
        if (angle<rectangle){
            handler.postDelayed(runnable, 50);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
