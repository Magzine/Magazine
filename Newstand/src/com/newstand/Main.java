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
		
		LinearLayout l = (LinearLayout)findViewById(R.id.GridLayout1); //XML Layout 불러옴
		//이미지 버튼 삽입
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.stand); //이미지에 등록할 비트맵 생성
		Matrix m = new Matrix();
        m.postTranslate(50, 50); //비트맵의 초기위치
        ImageView v2 = new ImageView(getBaseContext());
        v2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        v2.setScaleType(ScaleType.MATRIX);  // 매트릭스로 이동시키기 때문에 scaleType은 반드시 Matrix로 지정해야한다. 
        v2.setImageBitmap(bm);      // 이미지를 등록한다.
        v2.setImageMatrix(m);       // 매트릭스를 이미지뷰에 적용한다.
         
        l.addView(v2);      // 레이아웃에 이미지뷰를 등록한다.
        
		

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
