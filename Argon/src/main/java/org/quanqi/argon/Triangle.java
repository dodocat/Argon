package org.quanqi.argon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.Shape;

/**
 * By jingquanqi on 10/30/13.
 */
public class Triangle extends Shape {

    @Override
    public void draw(Canvas canvas, Paint paint) {

    }

    void init() {
        Path path = new Path();
        path.moveTo(50, 50);

        path.close();

//生成多边形
        ShapeDrawable mDrawable = new ShapeDrawable(new PathShape(path, 250, 250));
//mDrawable.getPaint（）.setColor（Color.RED）;
        Bitmap b1 =  Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);
        Shader aShader = new BitmapShader(b1, Shader.TileMode.REPEAT,Shader.TileMode.REPEAT);
        mDrawable.getPaint().setShader(aShader)  ;   //填充位图

        mDrawable.setBounds(0,0,250,250);    //设置鸿沟尺寸
    }
}
