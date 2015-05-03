package com.huayuan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class demo extends View {
	Paint mPaint = new Paint();
	int jian;
	int pian;
	int[] lineValue = new int[7];

	public demo(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint.setColor(Color.RED);
		mPaint.setStyle(Style.FILL);
		mPaint.setStrokeWidth(2f);
		mPaint.setAntiAlias(true);
		if(this.isInEditMode())
			return;
	}

	public demo(Context context) {
		this(context, null);
	}

	public demo(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		jian = this.getWidth() / lineValue.length;
		pian = this.getWidth() / 2 - 3 * jian;
		float bili = this.getHeight() / 100;
		
		for (int i = 0;i<lineValue.length;i++){
			int y = (int) (lineValue[i]*bili);
			canvas.drawRect(pian-jian/12, this.getHeight()-y, pian+jian/12, this.getHeight(), mPaint);
			pian+=jian;
		}
	}
	public void update (int v ){
		
		for (int i = 0;i < lineValue.length-1;i++){
			lineValue[i] = lineValue[i+1];
		}
		lineValue[lineValue.length-1]= v;
		invalidate();
	}
}
