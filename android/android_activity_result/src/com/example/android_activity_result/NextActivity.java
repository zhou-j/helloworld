package com.example.android_activity_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends Activity {
    private TextView textView;
    private Button button;
    private EditText editText;
	public NextActivity() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
		button = (Button)this.findViewById(R.id.button1);
		editText = (EditText)this.findViewById(R.id.editText1);
		
		textView = (TextView)this.findViewById(R.id.textView1);
	    Intent intent = getIntent();
	    String message = intent.getStringExtra("message");
	    textView.setText(message);
	    button.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				String value = editText.getText().toString().trim();
				Intent intent = new Intent();
				intent.putExtra("result",value);
				//设置回传的意图
				setResult(1001,intent);
				finish();
			}
	    	
	    });
	}
	

}
