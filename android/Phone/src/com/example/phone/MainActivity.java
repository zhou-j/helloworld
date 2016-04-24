package com.example.phone;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText nuText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 找到按钮对象
		Button callButton = (Button) findViewById(R.id.button1);
		nuText = (EditText) findViewById(R.id.editText1);
		// 获取其中的号码

		// 添加监听器
		callButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 找到文本框对象

				String num = nuText.getText().toString();

				// 呼叫此号码
				Intent intent = new Intent(); // 创建意图对象
				intent.setAction(Intent.ACTION_CALL);// 设置意图的动作为打电话
				intent.setData(Uri.parse("tel:" + num));// 设置意图的数据（电话号码）
				startActivity(intent); // 使用意图开启一个界面（拨打电话的界面）

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
