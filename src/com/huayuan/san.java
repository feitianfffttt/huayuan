package com.huayuan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class san extends Fragment {
	public san() {
		super();
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		inflater.inflate(R.layout.san, container,false);
		TextView textview = new TextView(getActivity());
		textview.setText("��Ҳ������");
		
//		return 	inflater.inflate(R.layout.two, container,false);
		return  textview;
	}

	

}
