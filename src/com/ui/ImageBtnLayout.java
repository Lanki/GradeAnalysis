package com.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageBtnLayout extends LinearLayout {
	
	private ImageView mImg;
	private TextView mText;
	private Context mContext;

	public ImageBtnLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.imgbtn, this, true);
		
		mContext = context;
		mImg = (ImageView) findViewById(R.id.img);
		mText = (TextView) findViewById(R.id.text);
		
	}
	
	/* ͼƬ���ýӿ� */
	public void setImageResource (int resId) {
		mImg.setImageResource(resId);
	}
	
	/* �������ýӿ� */
	public void setText(String str) {
		mText.setText(str);
	}
	
	/* ���ִ�С���� */
	public void setTextSize (float size) {
		mText.setTextSize(size);
	}

}
