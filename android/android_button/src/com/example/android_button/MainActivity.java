package com.example.android_button;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    private Button button;
    private Button button2;
    private Button button3;
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)this.findViewById(R.id.button1);
        button2 = (Button)this.findViewById(R.id.button2);
        button3 = (Button)this.findViewById(R.id.button3);
        imageButton = (ImageButton)this.findViewById(R.id.imageButton1);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        
//        button.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(MainActivity.this, "click button1", 1).show();
//			}
//		});
//        button.setOnLongClickListener(new OnLongClickListener() {
//			
//			@Override
//			public boolean onLongClick(View v) {
//				
//				Toast.makeText(MainActivity.this, "longclick button1 ", 1).show();
//				return false;
//			}
//		});
        		
        
    }

    public void sendMessage(View view){
    	Toast.makeText(MainActivity.this, "响应xml中的事件", 1).show();
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
	case R.id.button1:
		Toast.makeText(MainActivity.this, "button1", 1).show();	
		break;
	case R.id.button2:
		Toast.makeText(MainActivity.this, "button2", 1).show();	
		break;
	case R.id.button3:
		Toast.makeText(MainActivity.this, "button3", 1).show();	
		break;
	case R.id.imageButton1:
		Toast.makeText(MainActivity.this, "imageButton1", 1).show();	
		break;
		

	default:
		break;
	}
	}
    
}
