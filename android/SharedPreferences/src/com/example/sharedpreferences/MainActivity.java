package com.example.sharedpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText nameET;
	private EditText phoneET;
	private EditText emailET;
	private SharedPreferences sp;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        nameET = (EditText)findViewById(R.id.nameET );
        phoneET = (EditText)findViewById(R.id.phoneET);
        emailET = (EditText)findViewById(R.id.emailET);
        
        sp = getSharedPreferences("data", MODE_PRIVATE); //获取对象，默认指向当前应用，文件名为data.xml,模式为私有
        nameET.setText(sp.getString("name",""));  //获取数据，指定默认值
        phoneET.setText(sp.getString("phone", ""));
        emailET.setText(sp.getString("email", ""));
    }
    
    public void onClick(View view){
    	String name = nameET.getText().toString();
    	String phone = phoneET.getText().toString();
    	String email = emailET.getText().toString();
    	
    	
    	Editor editor  = sp.edit();//获取编辑器
    	editor.putString( "name", name); //存储数据（还没进入文件）
    	editor.putString( "phone", phone);
    	editor.putString("email", email );
    	editor.commit();    //提交修改；类似事物
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
