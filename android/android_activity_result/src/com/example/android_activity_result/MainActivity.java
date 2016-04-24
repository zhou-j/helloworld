package com.example.android_activity_result;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button button;
	private EditText editText1,editText2,editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button    = (Button)this.findViewById(R.id.button1);
        editText1 = (EditText)this.findViewById(R.id.editText1);
        editText2 = (EditText)this.findViewById(R.id.editText2);
        editText3 = (EditText)this.findViewById(R.id.editText3);
        button.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this,NextActivity.class);
				String a = editText1.getText().toString().trim();
				String b = editText2.getText().toString().trim();
				intent.putExtra("message",a+"+"+b+"="+"?");
				
				startActivityForResult(intent,1000);
				
			}
        	
        });
    }
    
    


    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 1000 && resultCode == 1001){
			String result_value = data.getStringExtra("result");
			editText3.setText(result_value);
		}
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
