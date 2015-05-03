package com.huayuan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class myCanvas extends View {

	private Paint mPaint = new Paint();
	int max = 50;
	int lineValue = 70;

	public myCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint.setColor(Color.YELLOW);
		mPaint.setStrokeWidth(2f);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Style.STROKE);
		mPaint.setTextSize(20);
//		if(this.isInEditMode()){
//			return;
//		} //测试方法是不是会有问题
	}

	public myCanvas(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public myCanvas(Context context) {
		this(context, null);
	}
	
	public void update(int wen){
		lineValue = wen ;
		invalidate();
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		float cx = this.getWidth();
//		float cy = this.getHeight();
//		Log.i("AAA", cx+"");
//		Log.i("AAA", cy+"");
		float cx = this.getWidth()/2;
		float cy = this.getHeight()/2;
		float radius = this.getHeight()/3;
		canvas.drawCircle(cx, cy, radius, mPaint);
		if (lineValue>max)
			mPaint.setColor(Color.RED);
		mPaint.setStyle(Style.FILL);
		RectF oval = new RectF(cx-radius,cy-radius,cx+radius,cy+radius);
		float sweepAngle = (float)lineValue/100*360;
		//Log.i("AAA", sweepAngle+"");
//		System.out.println(sweepAngle);
	    canvas.drawArc(oval, 0, sweepAngle, true, mPaint);
	    canvas.drawText(lineValue+"%", cx+radius/2, cy-radius/10, mPaint);
	    mPaint.setColor(Color.YELLOW);
	    mPaint.setStyle(Style.STROKE);
	}
}
