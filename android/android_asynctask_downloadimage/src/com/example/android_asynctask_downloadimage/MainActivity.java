package com.example.android_asynctask_downloadimage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private Button button;
    private ImageView imageView;
    private final String IMAGE_PATH = "https://www.baidu.com/img/bdlogo.png";
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)this.findViewById(R.id.button1);
        imageView = (ImageView)this.findViewById(R.id.imageView1);
        dialog = new ProgressDialog(this);
        dialog.setTitle("提示");
        dialog.setCancelable(false);
        dialog.setMessage("正在下载图片，请耐心等候.........");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new MyTask().execute(IMAGE_PATH);
			}
		});
    }
    
    public class MyTask extends AsyncTask<String, Integer, byte[]>{
    	@Override
    	protected void onPreExecute() {
    		super.onPreExecute();
    		dialog.show();
		}
    	
    	@Override
    	protected byte[] doInBackground(String... params) {
    		HttpClient httpClient = new DefaultHttpClient();
    		HttpGet httpGet = new HttpGet(params[0]);
    		byte[] result = null;
    		InputStream inputStream = null;
    		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    		try {
				  HttpResponse httpResponse = httpClient.execute(httpGet);
				  long file_length = httpResponse.getEntity().getContentLength();//文件总长度
				  int total_length = 0;
				  byte[] data = new byte[1024];
				  int len = 0 ;
                  if (httpResponse.getStatusLine().getStatusCode()==200) {
				//	result = EntityUtils.toByteArray(httpResponse.getEntity());
                	  inputStream = httpResponse.getEntity().getContent();
                	  while((len = inputStream.read(data))!=-1){
                		  total_length += len;
                		  int progress_value = (int)((total_length / (float)file_length )*100);
                		  publishProgress(progress_value);
                		  outputStream.write(data, 0, len);
                	  }
				}
                  result = outputStream.toByteArray();
    		} catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}finally{
				httpClient.getConnectionManager().shutdown();
			}
    		
    		return result;
    		
    	}
    	
    	@Override
    	protected void onProgressUpdate(Integer... values) {
    		super.onProgressUpdate(values);
    		dialog.setProgress(values[0]);
    	}
    	@Override
    	protected void onPostExecute(byte[] result) {
    		super.onPostExecute(result);
    		Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
    		imageView.setImageBitmap(bitmap);
    		dialog.dismiss();
			
		}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	
}
