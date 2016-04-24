package com.example.android_radiobutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onRadioButonClicked(View view) {
		RadioButton button = (RadioButton) view;
		boolean isChecked = button.isChecked();
		switch (view.getId()) {
		case R.id.radio0:
			if (isChecked) {
				Toast.makeText(MainActivity.this, button.getText(), 1);
			}

			break;
		case R.id.radio1:
			if (isChecked) {
				Toast.makeText(MainActivity.this, button.getText(), 1);
			}

			break;
		case R.id.radio2:
			if (isChecked) {
				Toast.makeText(MainActivity.this, button.getText(), 1);
			}

			break;

		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
