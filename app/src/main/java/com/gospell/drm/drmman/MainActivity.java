package com.gospell.drm.drmman;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.gospell.drm.DrmService.*;
import android.util.Log;
import android.os.StrictMode;


public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}	
			
		url=ContentDetail.UrlFromIntent(getIntent(),getContentResolver());
		if(url.isEmpty())
				url=ContentDetail.urlrio;//"http://192.168.25.140:1935/vod/mp4:sample.mp4/playlist.m3u8";
		tvUsername=(EditText) findViewById(R.id.editText1Username);
		tvUsername.setText("adm");
		tvPwd=(EditText) findViewById(R.id.editText1Pwd);
		tvPwd.setText("123456");
		tvRiurl=(EditText) findViewById(R.id.editText1Riurl);
		tvRiurl.setText("http://192.168.1.57:8180/3a_cs/soap/gos3a");
		bnLogin=(Button) findViewById(R.id.button1Login);
		bnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


				//Test();
/*
				int re;				
				if(ContentDetail.bUseDrmService)
					re=DrmService.Login(tvUsername.getText().toString(),tvPwd.getText().toString(),tvRiurl.getText().toString());
				else
					re=DrmServiceLocalTst.Login(tvUsername.getText().toString(),tvPwd.getText().toString(),tvRiurl.getText().toString());
				if(re!=0)
				{
					Toast.makeText(MainActivity.this, "connection error",
							Toast.LENGTH_LONG).show();
					return;
				}
	*/			
//				String sre;
//				if(ContentDetail.bUseDrmService)
//					sre = DrmService.P4Query("non");
//				else
//					sre = DrmServiceLocalTst.P4Query("non");

				lastUsername=tvUsername.getText().toString();
				lastPwd=tvPwd.getText().toString();
				bLoggedin=true;
				Intent intent = new Intent(act,ContentDetail.class);
				intent.setAction(Intent.ACTION_VIEW);
		        String type = "content/* ";
		        
				
		        Uri uri = Uri.parse(url);
		        intent.setDataAndType(uri, type);
		        startActivity(intent);  	
			}
		});
		
	}
	public static final String			TAG						= "DrmAgent";
	
	public void Test()
	{
//		byte[] baSend=new byte[]{97,98,99,0,100,101};
//		byte[] bar=DrmServiceLocalTst.P8SendDataTo(baSend,5
//		,DrmServiceLocalTst.EncryptionMethod.ENCRYPTION_NONE.ordinal()
//		,"http://192.168.3.155:8081/3a_cs/soap/gos3a");


		Log.d(TAG, "Test in");
		if(SystemHandle.init()!=0)
		{
			Log.d(TAG, "Test in, SystemHandle.init err");
			return;
		}
		String s1=SystemHandle.getStbID();
		if(s1==null)
			Log.d(TAG, "Test in, SystemHandle.getStbID err");
		else
		{
			Log.d(TAG, "Test in, SystemHandle.getStbID ok, s1="+s1);
			bnLogin.setText(s1);
			}

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	static private boolean bLoggedin=false; 
	Activity act =this;
	String url="";
	public static String lastUsername="",lastPwd="";
	Button bnLogin;
	EditText tvUsername;
	EditText tvPwd,tvRiurl;

}
