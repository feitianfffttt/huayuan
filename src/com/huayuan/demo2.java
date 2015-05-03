package com.huayuan;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class demo2 extends View {

	Paint mPaint = new Paint();
	Path mPath = new Path();
	int[] lineValue = new int[7];

	public demo2(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint.setColor(Color.RED);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Style.STROKE);
		mPaint.setStrokeWidth(4);

//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				while (true) {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					update(new Random().nextInt(100));
//
//				}
//			}
//		}).start();

	}

	public demo2(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public demo2(Context context) {
		this(context, null);
	}

	public void update(int v) {

		for (int i = 0; i < lineValue.length - 1; i++) {
			lineValue[i] = lineValue[i + 1];
		}

		lineValue[lineValue.length - 1] = v;
		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int jian = this.getWidth() / lineValue.length;
		int pian = this.getWidth() / 2 - 3 * jian;
		float dy = this.getHeight() / 100;
		mPath.reset();
		for (int i = 0; i < lineValue.length; i++) {
			int y = (int) (lineValue[i] * dy);
			if (i == 0 || lineValue[i - 1] == 0)
				mPath.moveTo(pian, getHeight() - y);

			mPath.lineTo(pian, this.getHeight() - y);
			pian += jian;
			// Log.i("AAA", pian+"```"+y);
		}
		canvas.drawPath(mPath, mPaint);
	}

}
