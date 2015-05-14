package com.newstand;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

public class Main extends Activity {
	@SuppressWarnings("deprecation")
	
	Button load_img; 

	  ImageView img; 

	  Bitmap bitmap; 

	  ProgressDialog pDialog; 

	  @Override

	  protected void onCreate(Bundle savedInstanceState) { 

	    super.onCreate(savedInstanceState); 

	    setContentView(R.layout.activity_main); 

	    load_img = (Button)findViewById(R.id.load); 

	    img = (ImageView)findViewById(R.id.img); 

	    load_img.setOnClickListener(new View.OnClickListener() { 

	      @Override

	      public void onClick(View arg0) { 

	        // TODO Auto-generated method stub 

	         new LoadImage().execute("http://www.learn2crack.com/wp-content/uploads/2014/04/node-cover-720x340.png"); 

	      } 

	    }); 

	  } 

	  private class LoadImage extends AsyncTask<String, String, Bitmap> { 

	    @Override

	        protected void onPreExecute() { 

	            super.onPreExecute(); 

	            pDialog = new ProgressDialog(Main.this); 

	            pDialog.setMessage("Loading Image ...."); 

	            pDialog.show(); 

	    } 

	       protected Bitmap doInBackground(String... args) { 

	         try { 

	               bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent()); 

	        } catch (Exception e) { 

	              e.printStackTrace(); 

	        } 

	      return bitmap; 

	       } 

	       protected void onPostExecute(Bitmap image) { 

	         if(image != null){ 

	           img.setImageBitmap(image); 

	           pDialog.dismiss(); 

	         }else{ 

	           pDialog.dismiss(); 

	           Toast.makeText(Main.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show(); 

	         } 

	       } 

	   } 

	

	
	/*protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LinearLayout l = (LinearLayout)findViewById(R.id.GridLayout1); //XML Layout �ҷ���
		//�̹��� ��ư ����
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.stand); //�̹����� ����� ��Ʈ�� ����
		Matrix m = new Matrix();
        m.postTranslate(50, 50); //��Ʈ���� �ʱ���ġ
        ImageView v2 = new ImageView(getBaseContext());
        v2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        v2.setScaleType(ScaleType.MATRIX);  // ��Ʈ������ �̵���Ű�� ������ scaleType�� �ݵ�� Matrix�� �����ؾ��Ѵ�. 
        v2.setImageBitmap(bm);      // �̹����� ����Ѵ�.
        v2.setImageMatrix(m);       // ��Ʈ������ �̹����信 �����Ѵ�.
         
        l.addView(v2);      // ���̾ƿ��� �̹����並 ����Ѵ�.
        
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override*/
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
