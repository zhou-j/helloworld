package com.example.android_spinner;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener{
	
   private Spinner spinner;
   private ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)this.findViewById(R.id.spinner1);
//        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,getDataSource());
//        spinner.setAdapter(adapter);
        //加载xml的方式。
         adapter = ArrayAdapter.createFromResource(this, R.array.planets_array,android.R.layout.simple_spinner_item);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);
         //注册监听器。
         spinner.setOnItemSelectedListener(this);
    }


    public List<String> getDataSource() {
    	List<String> list = new ArrayList<String>();
    	list.add("北京");
    	list.add("广州");
    	list.add("上海");
		return list;
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	
	

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		String item = spinner.getItemAtPosition(position).toString();
		Toast.makeText(MainActivity.this, "你选中了"+item+"选项", 1).show();
	}


	@Override
	public void onNothingSelected(AdapterView<?> parent) {
	}
    
}
