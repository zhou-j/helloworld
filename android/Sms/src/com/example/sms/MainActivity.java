package com.example.sms;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	private EditText numText;
	private EditText contentText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numText = (EditText) findViewById(R.id.numET);
        contentText = (EditText) findViewById(R.id.contentET);
        
    }
    
   
	public void onClick(View view){
    	//获取号码和内容
    	String num = numText.getText().toString();
    	String content = contentText.getText().toString();
    	
    	//把内容发到指定的号码上
    	android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();//获取短信管理器
    	ArrayList<String> list = smsManager.divideMessage(content);//将短信内容分段加入arraylist;    	
    	for(String sms:list)       //遍历每一段短信
    	smsManager.sendTextMessage(num, null, sms, null, null); //发送每一段信息
    	//发送成功通知
    	Toast.makeText(getApplicationContext(), "发送成功", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
