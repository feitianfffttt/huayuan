package com.huayuan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class zhuzi extends View {

	Paint mPaint = new Paint();
	float x;
	float y;
	private int tmin = -20;// �¶����ֵ
	private int max = 30;// �¶�Ԥ����ֵ
	private int min = 0; // �¶�Ԥ��Сֵ
	private int tmax = 100;// �¶ȱ���ֵ
	int[] lineValue = new int[7];
	private int hSpace;
	private int offsetX;
	Path mPath = new Path();

	public zhuzi(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint.setColor(Color.YELLOW);
		mPaint.setStrokeWidth(2f);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Style.FILL);
		
		mPaint.setTextSize(15);
		if (this.isInEditMode()) // ���Ⲽ���ļ�����
			return;
	}

	public zhuzi(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public zhuzi(Context context) {
		this(context, null);
	}

	public void update(int value) {

		for (int i = 0; i < lineValue.length - 1; i++) {
			lineValue[i] = lineValue[i + 1];
		}
		lineValue[lineValue.length - 1] = value;
		invalidate();
	}
	@Override
	protected void onDraw(Canvas canvas) {
		hSpace = this.getWidth() / lineValue.length;// ���ݵ���
		offsetX = this.getWidth() / 2 -  3*hSpace; // ��ʼxƫ����
		float rate = (float) this.getHeight() / tmax; // ������������Ա���
		
		Log.i("AAA", hSpace+"---"+offsetX+"---"+rate);
		mPath.reset();
		for (int i = 0; i < lineValue.length; i++) {
			int y = lineValue[i];
			y = (int) (y * rate);
			
			
			// ��һ�λ�λ��
			if (i == 0 || lineValue[i - 1] == 0)
				mPath.moveTo(offsetX, getHeight() - y);
			mPath.lineTo(offsetX, getHeight() - y);
			if (lineValue[i] > max || lineValue[i] < min)
				mPaint.setColor(Color.RED);
			mPaint.setStyle(Style.FILL);
			canvas.drawRect(offsetX - hSpace / 12, this.getHeight() - y,
					offsetX + hSpace / 12, this.getHeight(), mPaint);
			canvas.drawText(lineValue[i] + "", offsetX - hSpace / 6,
					getHeight() - y - 10, mPaint);
			mPaint.setStyle(Style.STROKE);
			// ��һ��λ��
			offsetX += hSpace;
			mPaint.setColor(Color.YELLOW);
		}
		canvas.drawPath(mPath, mPaint);
		canvas.drawLine(hSpace / 6, this.getHeight(), getWidth() - hSpace / 6,
				this.getHeight(), mPaint);
		mPaint.setStyle(Style.FILL);
//		canvas.drawText("�¶�", getWidth() - hSpace, 20, mPaint);
		mPaint.setStyle(Style.STROKE);
	}
	
	
}
