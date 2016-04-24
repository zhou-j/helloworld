package com.example.android_activity_start;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)this.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
			
				Intent intent = new Intent(MainActivity.this,NextActivity.class);
				intent.putExtra("name","jack");
				intent.putExtra("age",23);
				intent.putExtra("address","±±¾©");
				Bundle bundle = new Bundle();
				bundle.putString("code","1001");
				intent.putExtra("bundle",bundle);
				
				
				//Æô¶¯Activity
				startActivity(intent);
				
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
