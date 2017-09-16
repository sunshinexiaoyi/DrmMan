package com.gospell.drm.drmman;

import java.util.Date;
import java.util.Vector;

import squashxml.xml.XMLDocument;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.text.ParseException;
import android.util.Log;


import com.gospell.soap.services.bean.pub.DrmResult;
import com.gospell.soap.services.bean.pub.ResultDoc;
import com.gospell.soap.services.bean.ri.*;
import com.gospell.soap.enums.EnumDrmHandleResultCode;
import com.gospell.drm.DrmService.*;

public class ContentDetail extends Activity {

	static final public boolean bUseDrmService=false;
    //static public String urlrio="http://192.168.8.111:1935/vod/_definst_/vod/mp4:499d5ef6412b4132aff097805b661565.mp4/playlist.m3u8";
	//static public String urlrio="http://192.168.51.101:1935/vod/_definst_/vod/mp4:77b5b90df3194b0db5d64a4e57687357.mp4/playlist.m3u8";
	//static public String urlrio="http://192.168.1.84:1935/vod/_definst_/vod/mp4:6ac63a55365544beb7a33922d284bebb.mp4/playlist.m3u8";
	//String urliron="http://114.215.105.163:1935/vod/_definst_/vod/mp4:02025661641e47ca8724a5ede63b0f8e.mp4/playlist.m3u8";
	//static public String urlrio="http://192.168.120.21:1935/vod/_definst_/vod/mp4:20170504/95b4666215f44555b09a7d951516fc10.mp4/manifest.mpd";
    //String urliron="http://192.168.120.21:1935/vod/_definst_/vod/mp4:20170504/95b4666215f44555b09a7d951516fc10.mp4/manifest.mpd";
    static public String urlrio="http://192.168.1.109:8091/vod/EvFdJHML7uvu0dsC/EvFdJHML7uvu0dsC.mpd";
    String urliron="http://192.168.1.109:8091/vod/EvFdJHML7uvu0dsC/EvFdJHML7uvu0dsC.mpd";
    String urlmeninblack="http://114.215.105.163:1935/vod/_definst_/vod/mp4:Men_in_Black_III.mp4/playlist.m3u8";
    String urlstream="http://192.168.3.163:1935/live/_definst_/stream/cctv4_dvr.stream/playlist.m3u8";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_detail);
		
		url=UrlFromIntent(getIntent(),getContentResolver());

		SetupCtrls();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	static public String UrlFromIntent(Intent itnt,ContentResolver cr)
	{
		String re="";
		if(itnt==null || cr==null)
			return re;
        if (itnt.getAction() != null
                && itnt.getAction().equals(Intent.ACTION_VIEW)) {
        	Uri uri=itnt.getData();
        	re=uri.toString();
        }
        return re;
	}

	public void ClearFields()
	{
		textView1status.setText("");
		editText1Count.setText("");
		editText1starttime.setText("");
		editText1endtime.setText("");
	}

	public void LoadLicense()
	{
		String re ;
		if(bUseDrmService)
			re = DrmService.P4Query(url);
		else
			re = DrmServiceLocalTst.P4Query(url);

		DrmResult ret = new DrmResult(re);
		int status = ret.GetStatus(); 
		ClearFields();

		if(status==EnumDrmHandleResultCode.CHINADRM_ERROR_OK.getHandleResultCode())
		{
			RoDocument ro;
			ro=ret.GetRoDocument();
			if(ro!=null)
			{
				textView1cid.setText(ro.getCid());
				editText1Count.setText(ro.getCount());
				if(ro.getStartTime()!=null)
					editText1starttime.setText(ro.getStartTime().toString());
				if(ro.getEndTime()!=null)
					editText1endtime.setText(ro.getEndTime().toString());
				textView1status.setText("Loading license success");
			}
			else
				textView1status.setText("Loading License fails, ro=0");
		}
		else if(status==EnumDrmHandleResultCode.UDRM_ERROR_CONTENT_NOT_EXIST.getHandleResultCode())
		{
			editText1Count.setText("");
			editText1starttime.setText("");
			editText1endtime.setText("");
			textView1status.setText("Content not registered");
		}
		else if(status==EnumDrmHandleResultCode.UDRM_ERROR_PROGRAM_RI_NO_RIGHT.getHandleResultCode())
		{
			editText1Count.setText("");
			editText1starttime.setText("");
			editText1endtime.setText("");
			textView1status.setText("No License found for this Content");
		}
		else if(status==EnumDrmHandleResultCode.UDRM_ERROR_VERSION_NEED_UPDATE.getHandleResultCode())
		{
			editText1Count.setText("");
			editText1starttime.setText("");
			editText1endtime.setText("");
			textView1status.setText("DrmAgent needs update");
		}
		else if(status==EnumDrmHandleResultCode.UDRM_ERROR_NETWORK_CONNECTION_ERROR.getHandleResultCode())
		{
			editText1Count.setText("");
			editText1starttime.setText("");
			editText1endtime.setText("");
			textView1status.setText("network connection error");
		}
		
		else
			textView1status.setText(re);
	}

	String url="";
	Button button1Request,button1Refresh,button1,button2,button1Doplay,button1Play;
	TextView textView2Title,textView1cid,textView1status;
	EditText editText1Count,editText1starttime,editText1endtime;
	void SetupCtrls()
	{
		textView1cid=(TextView) findViewById(R.id.textView1cid);
		textView1status=(TextView) findViewById(R.id.textView1status);
		editText1Count=(EditText) findViewById(R.id.editText1Count);
		editText1starttime=(EditText) findViewById(R.id.editText1starttime);
		editText1endtime=(EditText) findViewById(R.id.editText1endtime);

		textView2Title=(TextView) findViewById(R.id.textView2Title);
		textView2Title.setText(url);
		
		button1Refresh=(Button) findViewById(R.id.button1Refresh);
		button1Refresh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				long startTime = System.currentTimeMillis();
				Log.d("DrmAgent", "-----> Loadtime1: " + startTime);
				LoadLicense();
				long estimatedTime = System.currentTimeMillis() - startTime;
				Log.d("DrmAgent", "-----> Loadtime2: " + estimatedTime);
			}
		});
		
		button1Request=(Button) findViewById(R.id.button1Request);
		button1Request.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RoDocument ro=new RoDocument();
				if(url.equalsIgnoreCase(urliron))
					ro.setCid("02025661641e47ca8724a5ede63b0f8e");
				else
					ro.setCid("6ac63a55365544beb7a33922d284bebb");
				
				ro.setCount(editText1Count.getText().toString());
//				ro.setStartTime(editText1starttime.getText().toString());
//				ro.setEndTime(editText1endtime.getText().toString());
				Date dt = new Date(System.currentTimeMillis());
				ro.setStartTime(dt);
				Date dt1 = addMonthTime(dt,2);
				ro.setEndTime(dt1);

				Vector<XMLDocument> vt=new Vector<XMLDocument>();
				vt.add(ro);
				RosDocument ros=new RosDocument();
				ros.setVector(vt);
				String str=ros.encode();
				String re ;
				long startTime = System.currentTimeMillis();
				Log.d("DrmAgent", "-----> time1: " + startTime);
				if(bUseDrmService)
					re = DrmService.P5LicenseRequest(str);
				else
					re = DrmServiceLocalTst.P5LicenseRequest(str);
				long estimatedTime = System.currentTimeMillis() - startTime;
				Log.d("DrmAgent", "-----> time2: " + estimatedTime);

				DrmResult ret = new DrmResult(re);
				int status = ret.GetStatus(); 
				if(status==EnumDrmHandleResultCode.CHINADRM_ERROR_OK.getHandleResultCode())
				{
				}

				ClearFields();
				textView1status.setText(re);
				if(re.equalsIgnoreCase("LicenseRequest success"))
					LoadLicense();
			}
		});

		button1Doplay=(Button) findViewById(R.id.button1Doplay);
		button1Doplay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String re ;
				if(bUseDrmService)
					re = DrmService.P7CanDoAction(url,0);
				else
					re = DrmServiceLocalTst.P7CanDoAction(url,0);

				DrmResult ret = new DrmResult(re);
				int status = ret.GetStatus(); 
				if(status != EnumDrmHandleResultCode.CHINADRM_ERROR_OK.getHandleResultCode())
				{
					ClearFields();
					textView1status.setText(re);
					}

				if(bUseDrmService)
					re = DrmService.P6DoAction(url,0);
				else
					re = DrmServiceLocalTst.P6DoAction(url,0);

				ClearFields();
				textView1status.setText(re);
			}
		});
		
		button1Play=(Button) findViewById(R.id.button1Play);
		button1Play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
		        String type = "video/*";
		        Uri uri = Uri.parse(url);
		        intent.setDataAndType(uri, type);
		        startActivity(intent);  	
			}
		});
		
		button1=(Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				url=urliron;
				textView2Title.setText(url);
				textView1cid.setText("95b4666215f44555b09a7d951516fc10.mp4");
			}
		});

		button2=(Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				url=urlrio;
				textView2Title.setText(url);
				textView1cid.setText("95b4666215f44555b09a7d951516fc10.mp4");
			}
		});

		if(url.isEmpty())
		{
			button1Request.setEnabled(false);
			button1Refresh.setEnabled(false);
		}
	}

	public static Date addMonthTime(Date date,int number) {
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  calendar.add(Calendar.MONTH, +number);
		  return calendar.getTime();
	}


}
