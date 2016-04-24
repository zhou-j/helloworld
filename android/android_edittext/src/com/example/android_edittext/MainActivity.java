package com.example.android_edittext;

import java.security.KeyException;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button button ;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)this.findViewById(R.id.button1);
        editText = (EditText)this.findViewById(R.id.editText1);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String value = editText.getText().toString().trim();
				if(value == null || value.equals("")){
					editText.setError("请输入用户名");
					return;
				}
				Toast.makeText(MainActivity.this, "--->>"+value, 1).show();
			}
		});
        editText.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(keyCode==KeyEvent.KEYCODE_ENTER){
					Toast.makeText(MainActivity.this, "按下回车键", 1).show();
				}
				return false;
			}
		});
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
