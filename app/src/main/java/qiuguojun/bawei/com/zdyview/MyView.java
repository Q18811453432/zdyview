package qiuguojun.bawei.com.zdyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import java.util.Random;

public class MyView extends View implements View.OnClickListener{
    private  int mwidth;
    private Paint mpaint;
    private String[] contents=new String[]{"美女","女神","少女","模特","宅女","大汉","女神"};
    private int[] mColor = new int[]{0xffffc300,0xFFD9B114,0xFFDC0B2E,0xFF5510A4,0xFF447C42,0xFFEC36};
    public MyView(Context context,AttributeSet attrs) {
        super(context, attrs);
       mpaint=new Paint();
       setOnClickListener(this);
       }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(400,400);
        mwidth=getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mpaint.setColor(Color.WHITE);
        mpaint.setAntiAlias(true);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeWidth(3);
        RectF rectF=new RectF(0,0,mwidth,mwidth);
        canvas.drawCircle(mwidth/2,mwidth/2,mwidth/2,mpaint);
        for (int i = 0; i <mColor.length; i++) {
            mpaint.setColor(mColor[i]);
            mpaint.setStyle(Paint.Style.FILL);
            int starAngle=60*i;
            canvas.drawArc(rectF,starAngle,60,true,mpaint);
        }
        mpaint.setColor(Color.BLACK);
        mpaint.setTextSize(40);
        for (int i = 0; i <contents.length; i++) {
            Path path=new Path();
            int startagln=60*i;
            path.addArc(rectF,startagln,60);
            canvas.drawTextOnPath(contents[i],path,90,60,mpaint);
        }
        mpaint.setColor(Color.RED);
        canvas.drawCircle(mwidth/2,mwidth/2,70,mpaint);
        mpaint.setColor(Color.BLACK);
        String str="Start";
        Rect rect=new Rect();
        mpaint.getTextBounds(str,0,str.length(),rect);
        int width=rect.width();
        int height=rect.height();
        canvas.drawText(str,mwidth/2-width/2,mwidth/2+height/2,mpaint);
    }

    @Override
    public void onClick(View v) {
        Random random=new Random();
        int zhuan=random.nextInt(1000)+360;
        int mStrat=zhuan%360;
        RotateAnimation rotateAnimation=new RotateAnimation(mStrat,zhuan,mwidth/2,mwidth/2);
rotateAnimation.setDuration(2000);
rotateAnimation.setFillAfter(true);
startAnimation(rotateAnimation);
    }
}
