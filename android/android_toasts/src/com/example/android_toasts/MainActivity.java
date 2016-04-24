package com.example.android_toasts;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button;
    private Button button2 ; 
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)this.findViewById(R.id.button1);
        button2 =(Button)this.findViewById(R.id.button2); 
        button.setOnClickListener(new View.OnClickListener() {
			
		
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(MainActivity.this, "XXXX", Toast.LENGTH_LONG);
				toast.setGravity(Gravity.TOP|Gravity.LEFT, 20,20);
				toast.show();
			}
		});
        button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				View layout = LayoutInflater.from(MainActivity.this).inflate(R.layout.toast, null);
				TextView textView = (TextView)layout.findViewById(R.id.text);
				textView.setText("hello tupianlaili");
				Toast toast = new Toast(MainActivity.this);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
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
