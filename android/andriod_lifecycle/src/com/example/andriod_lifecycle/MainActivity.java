package com.example.andriod_lifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private final String TAG = "MainActivity";

	/*
	 * 1.第一被调用。仅仅被调用一次 2.初始化布局View或者绑定数据
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "---onCreate->>");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "---onStart->>");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "---onResume->>");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "---onPause->>");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "---onStop->>");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "---onDestroy->>");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
