package com.example.scdemo;

import com.itbox.widget.ElasticScrollView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnClickListener, OnSeekBarChangeListener {

	private ElasticScrollView sv;
	private ImageView iv;
	private SeekBar sb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sv = (ElasticScrollView) findViewById(R.id.sv);
		iv = (ImageView)findViewById(R.id.iv);
//		sv.setElasticView(iv);
		findViewById(R.id.btn_type).setOnClickListener(this);
		findViewById(R.id.btn_damk).setOnClickListener(this);
		sb = (SeekBar) findViewById(R.id.seekBar1);
		sb.setProgress(10);
		sb.setOnSeekBarChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.btn_type:
			if(sv.getElasticView() == null){
				sv.setElasticView(iv);
			}else{
				sv.setElasticView(null);
			}
			
			break;
		case R.id.btn_damk:
			sb.setProgress(10);
			
			break;
		default:
			break;
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		sv.setDamk(progress/10 +1); 
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		
	}

}
