package com.gospell.drm.drmman;

import java.util.Arrays;

import android.util.Log;
import com.gospell.drm.drmman.CommandEnums;
import com.gospell.drm.drmman.Constants;

public class SystemHandle extends BaseCommand
{
	public static boolean bConnectToService=false;
	/*-------------------------------------------------------------------------------------------*/
	/*
	 * 初始化dvb系统, 创建java层与linux层 socket通讯接口
	 */
	/*-------------------------------------------------------------------------------------------*/
	public static int init()
	{
		int rec_len = 0;
		
		//还未与底层dvb连接上，则与底层进行连接
		if(bConnectToService == false)
		{
			if(!connectDVB())
			{
				//连接失败
				System.out.println("------------------------------>connect dvb failed !");
			return -1;
			}
			
			
			//发送询问连接的命令
			makeMsgHead(CommandEnums.CMD_SYS_ASK_CONNECT.getValue());
			makeMsgEnd();
			rec_len = sendAndReceiveMsg();
			if((rec_len - 4) < 0)
			{
				Log.d(TAG, "ask connect  err,rec_len = " + rec_len);
				closeConnectDVB();
				return -1;
			}
			if (getInt(recBuf, rec_len - 4) != rec_len)
			{
				Log.d(TAG, "ask connect  err!\n");
				closeConnectDVB();
				return -1;
			}
			clientID = recBuf[3];
			
			//发送初始化的命令
			makeMsgHead(CommandEnums.CMD_SYS_INITIAL_DVB.getValue());
			makeMsgEnd();
			rec_len = sendAndReceiveMsg();
			if((rec_len - 4) < 0)
			{
				Log.d(TAG, "CMD_SYS_INITIAL_DVB  err,rec_len = " + rec_len);
				closeConnectDVB();
				return -1;
			}
			if (getInt(recBuf, rec_len - 4) != rec_len)
			{
				Log.d(TAG, "CMD_SYS_INITIAL_DVB  err,rec_len = " + rec_len);
				closeConnectDVB();
				return -1;
			}
			bConnectToService=true;
		}		
		return 0;
	}


	/*-------------------------------------------------------------------------------------------*/
	// 获取机顶盒序列号
	/*-------------------------------------------------------------------------------------------*/		
	public static String getStbID()
	{
		int rec_len = 0;
		
		makeMsgHead(CommandEnums.CMD_SYS_GET_STB_ID.getValue());
		makeMsgEnd();
		rec_len = sendAndReceiveMsg();
		if (rec_len != getInt(recBuf, rec_len - 4))
		{
			Log.d(TAG, "CMD_SYS_GET_STB_ID error !");
			return null;
		}
		
		setRecBufOffset(MSG_HEAD_LEN);
		int len = getInt();
		if (len <= 0)
		{
			Log.d(TAG, "CMD_SYS_GET_STB_ID read leng error !");
			return null;
		}
		else
		{
			byte[] buf = new byte[len];
			arrayCopyFromRecbuf(buf, 0, len);
			Log.d(TAG, "CMD_SYS_GET_STB_ID ok !");
			return new String(buf);
		}
	}

	
}
