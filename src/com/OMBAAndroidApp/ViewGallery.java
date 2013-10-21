package com.OMBAAndroidApp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

public class ViewGallery extends Activity{

	private ProgressDialog progressDialog;
	
	private Integer[] mImageIds = {
            R.drawable.building,
            R.drawable.welcome,
            R.drawable.houston,
            R.drawable.jpchase2,
            R.drawable.nyc
    };
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gallery);
        
	    Button home=(Button)this.findViewById(R.id.home);
	    Gallery gallery = (Gallery) findViewById(R.id.gallery1);
	    gallery.setAdapter(new ImageAdapter(this));
        Button lg=(Button)this.findViewById(R.id.lg);
        
        lg.setOnClickListener(new OnClickListener(){        
    	      
        	   @Override
        	   public void onClick(View v) {
        		   progressDialog = ProgressDialog.show(ViewGallery.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
        		   LoginScreen.cc=0;
        		   finish();
              	   Intent logoutIntent = new Intent(ViewGallery.this, LoginScreen.class);
                   logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(logoutIntent);
        	   }catch (Exception e) {

                   Log.e("tag", e.getMessage());

                   }

                   // dismiss the progress dialog

                   progressDialog.dismiss();

                   }

                   }.start();
                   }
           });
	    home.setOnClickListener(new OnClickListener(){        
	  	      
     	   @Override
     	   public void onClick(View v) {
     		  progressDialog = ProgressDialog.show(ViewGallery.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
              finish();
     		   Intent i=new Intent(ViewGallery.this, HomeScreen.class);
  		         startActivity(i);
     	   }catch (Exception e) {

               Log.e("tag", e.getMessage());

               }

               // dismiss the progress dialog

               progressDialog.dismiss();

               }

               }.start();
               }
        });
	    
	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        @SuppressWarnings("rawtypes")
			public void onItemClick(AdapterView parent, View v, int position, long id) {
	        	ImageView imageView = (ImageView) findViewById(R.id.image1);                
                imageView.setImageResource(mImageIds[position]);
	        }
	    });
	}


public class ImageAdapter extends BaseAdapter {
    int mGalleryItemBackground;
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.ViewGallery);
        mGalleryItemBackground = attr.getResourceId(
                R.styleable.ViewGallery_android_galleryItemBackground, 0);
        attr.recycle();
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mImageIds[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(80, 60));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(mGalleryItemBackground);

        return imageView;
    }
}
@Override
public void onBackPressed() {    
	ViewGallery.this.finish();
	Intent i=new Intent(ViewGallery.this, HomeScreen.class);
    startActivity(i);
}

}