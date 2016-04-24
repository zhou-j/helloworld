package com.example.android_checkboxes;

import java.text.BreakIterator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
     
   //注册监听事件
    public void onCheckboxClicked(View view){
    	//判断哪一checkBox被选中
    	CheckBox checkBox = (CheckBox)view;
    	boolean isCheck = checkBox.isChecked();
    	switch (view.getId()) {
		case R.id.checkBox1:
			if (isCheck) {
				Toast.makeText(MainActivity.this, "--->>"+checkBox.getText(), 1).show();
			}else {
				//remove
			}	
			break;
            case R.id .checkBox2:
            	if (isCheck) {
            		Toast.makeText(MainActivity.this, "--->>"+checkBox.getText(), 1).show();
				}else {
					
				}
            	break;
            case R.id .checkBox3:
            	if (isCheck) {
            		Toast.makeText(MainActivity.this, "--->>"+checkBox.getText(), 1).show();
				}else {
					
				}
            	break;
            case R.id .checkBox4:
            	if (isCheck) {
            		Toast.makeText(MainActivity.this, "--->>"+checkBox.getText(), 1).show();
				}else {
					
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
