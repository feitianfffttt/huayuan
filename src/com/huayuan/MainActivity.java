package com.huayuan;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends ActionBarActivity {

	myCanvas my;
	zhuzi zz;
	demo de;
	demo2 de2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	//	my = (myCanvas) findViewById(R.id.canvas1);
	//	zz = (zhuzi) findViewById(R.id.canvas1);
	//	de = (demo) findViewById(R.id.canvas1);
		de2 = (demo2) findViewById(R.id.canvas1);
		de2.update(new Random().nextInt(100));
		handler.sendEmptyMessageDelayed(1, 1000);
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			de2.update(new Random().nextInt(100));
			handler.sendEmptyMessageDelayed(1, 1000);
		}
	};
}
