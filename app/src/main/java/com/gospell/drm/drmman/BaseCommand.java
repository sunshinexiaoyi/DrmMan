package com.gospell.drm.drmman;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import com.gospell.drm.drmman.Constants;
import android.util.Log;


public class BaseCommand
{
	public static final String			TAG						= "DrmAgent";
	/*----------------------------------Constants------------------------------------------*/
	public static final byte		MSG_HEAD_LEN		= 8;
	public static final byte		MAX_SERVICE_NAME_LEN= 32;
	
	protected static final byte[]	sendBuf				= new byte[1024];			// 填装通过socket发送到底层的数据数组
	protected static final byte[]	recBuf				= new byte[5120];			// 接收通过socket从底层传回的数据数组

	/*-----------------------------------Variables----------------------------------------*/
	private static int				sendBufOffset		= 0;						// sendBuf中的偏移位置
	private static int				recBufOffset		= MSG_HEAD_LEN;				// recBuf中的偏移位置,初始为8的原因是，底层发上来的要获取的相关信息都是从recBuf[8]开始的
	
	protected static boolean		bConnectToService	= false;					// 是否与服务器建立连接的标志
	protected static byte 			clientID			= 0;
	protected static Socket			sd;
	protected static Socket			checkApkSd;
	protected static OutputStream	out;
	protected static OutputStream	checkApkOut;
	protected static InputStream	in;

	/**
	 * 与底层dvb创建连接
	 * @return
	 */
	protected static boolean connectDVB()
	{
		try
		{
				Log.d(TAG, "connectDVB in");
			sd 			= new Socket(InetAddress.getByName("127.0.0.1"), Constants.HOST_PORT);
			if(sd==null)
				Log.d(TAG, "connectDVB in sd==null");
			out 		= sd.getOutputStream();
			in 			= sd.getInputStream();
			
			if(out != null && in != null)
			{
				bConnectToService = true;
				Log.d(TAG, "connectDVB: ok");
				return true;
			}
		}
		catch (Exception e) 
		{
			Log.d(TAG, e.getMessage());
			e.printStackTrace();
		}
				Log.d(TAG, "connectDVB: return false");
		return false;	
	}
	
	/**
	 * 关闭与底层dvb的连接
	 */
	protected static void closeConnectDVB() 
	{
		try
		{
			sd.close();
			checkApkSd.close();
			in.close();
			out.close();
			checkApkOut.close();
			bConnectToService = false;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 向底层dvb发送数据并接收返回的数据
	 * @return 底层dvb返回的数据的长度
	 */
	protected static int sendAndReceiveMsg()
	{
		int out_len = 0;
		if (bConnectToService == false)
		{
			System.out.println("bConnectToService false!");
			return MSG_HEAD_LEN + 4;
		}
		
		try
		{
			out.write(sendBuf, 0, sendBufOffset);
			int i;
			for(i=0;i<sendBufOffset;i++)
				Log.d(TAG, "sendAndReceiveMsg, sendbuf:"+Integer.toString(sendBuf[i])
				+",i="+Integer.toString(i));

			out_len = in.read(recBuf, 0, 5120);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return out_len;
	}	
	
	/**
	 * 组装信息头
	 * @param cmdID	要发送的命令的值
	 */
	protected static void makeMsgHead(int cmdID)
	{
		sendBufOffset = 0;
		sendBuf[sendBufOffset++] = 0x43;// 'C';
		sendBuf[sendBufOffset++] = 0x4D;// 'M';
		sendBuf[sendBufOffset++] = 0x44;// 'D';
		sendBuf[sendBufOffset++] = clientID;
		setInt(cmdID);
	}

	/**
	 * 设置要发送给底层dvb的数据的尾部 	
	 */
	protected static void makeMsgEnd()
	{
		int value = sendBufOffset + 4;
		setInt(value);
	}

	/**
	 * 设置数据接收数组recBuf的偏移值（在向底层发送的每个命令处理过程中，如果需要从recBuf中获取数据，必须在获取数据前设置你要获取数据的开始位置）
	 * @param offset
	 */
	protected static void setRecBufOffset(int offset)
	{
		recBufOffset = offset;
	}

	/**
	 * 往要发给底层dvb的数组中填充一字节的数据
	 * @param value
	 */
	protected static void setByte(byte value)
	{
		sendBuf[sendBufOffset++] = value;
	}

	/**
	 * 从底层dvb返回的数据的数组中获取一字节的值
	 * @return
	 */
	protected static byte getByte()
	{
		return recBuf[recBufOffset++];
	}

	/**
	 * 往要发给底层dvb的数组中填充一short型的数据
	 * @param value
	 */
	protected static void setShort(short value)
	{
		sendBuf[sendBufOffset++] = (byte) ((value >> 8) & 0xff);
		sendBuf[sendBufOffset++] = (byte) (value & 0xff);
	}

	/**
	 * 从底层dvb返回的数据的数组中获取一short型的值
	 * @return
	 */
	protected static short getShort()
	{
		short a = 0;
		int tmp = 0;
		for (int i = 0; i < 2; i++)
		{
			tmp = (recBuf[recBufOffset] >= 0 ? recBuf[recBufOffset] : 256 + recBuf[recBufOffset]);
			a += tmp << (8 * (1 - i));
			recBufOffset++;
		}
		return a;
	}

	/**
	 *  往要发给底层dvb的数组中填充一int型的数据
	 * @param value
	 */
	protected static void setInt(int value)
	{
		sendBuf[sendBufOffset++] = (byte) ((value >> 24) & 0xff);
		sendBuf[sendBufOffset++] = (byte) ((value >> 16) & 0xff);
		sendBuf[sendBufOffset++] = (byte) ((value >> 8) & 0xff);
		sendBuf[sendBufOffset++] = (byte) (value & 0xff);
	}
	
	/**
	 * 从底层dvb返回的数据的数组中获取一int型的值
	 * @return
	 */
	protected static int getInt()
	{
		int a = 0;
		int tmp = 0;

		for (int i = 0; i < 4; i++)
		{
			tmp = (recBuf[recBufOffset] >= 0 ? recBuf[recBufOffset] : 256 + recBuf[recBufOffset]);
			a += tmp << (8 * (3 - i));
			recBufOffset++;
		}

		return a;
	}

	/**
	 * 从数组b中的start位置开始处获取一int型的数据
	 * @param b
	 * @param start
	 * @return
	 */
	protected static int getInt(byte b[], int start)
	{
		int a = 0;
		int tmp = 0;
		if(start < 0)
		{
			System.out.println("getInt error,invalue start = " + start);
			return a;
		}
		for (int k = 0; k < 4; k++)
		{
			tmp = (b[start + k] < 0) ? 256 + (int) (b[start + k]) : b[start + k];
			a += (tmp << (8 * (3 - k)));
		}
		return a;
	}
	
	/**
	 *  往要发给底层dvb的数组中填充一long型的数据
	 * @param value
	 */	
	protected static void setLong(long value)
	{
		sendBuf[sendBufOffset++] = (byte) ((value >> 56) & 0xff);
		sendBuf[sendBufOffset++] = (byte) ((value >> 48) & 0xff);
		sendBuf[sendBufOffset++] = (byte) ((value >> 40) & 0xff);
		sendBuf[sendBufOffset++] = (byte) ((value >> 32) & 0xff);
		sendBuf[sendBufOffset++] = (byte) ((value >> 24) & 0xff);
		sendBuf[sendBufOffset++] = (byte) ((value >> 16) & 0xff);
		sendBuf[sendBufOffset++] = (byte) ((value >> 8) & 0xff);
		sendBuf[sendBufOffset++] = (byte) (value & 0xff);
	}

	/**
	 * 从底层dvb返回的数据的数组中获取一long型的数据
	 * @return
	 */	
	protected static long getLong()
	{
		long a = 0;
		int tmp = 0;

		for (int i = 0; i < 8; i++)
		{
			// 通过遍历获取字节数
			tmp = (recBuf[recBufOffset] >= 0 ? recBuf[recBufOffset] : 256 + recBuf[recBufOffset]);
			a += tmp << (8 * (7 - i));
			recBufOffset++;
		}
		return a;
	}
	
	/**
	 * 从数组b中的start位置处通过4个字节获取一long型的值
	 * @param b
	 * @param start
	 * @return
	 */
	protected static long getLongByFourByte(byte b[], int start)
	{
		long a = 0;
		long tmp = 0;
		for (int k = 0; k < 4; k++)
		{
			tmp = (b[start + k] < 0) ? 256 + (int) (b[start + k]) : b[start + k];
			a += (tmp << (8 * (3 - k)));
		}
		return a;
	}
	
	/**
	 * 在数组b的start位置处通过从高位到低位获取某一整数
	 * @param b
	 * @param start
	 * @return
	 */
	protected static int getIntHL(byte b[], int start)
	{
		if (null == b || start < 0 || start > (b.length - 4))
		{
			return -1;
		}
		int ret = 0;
		int tmp = 0;
		for (int k = 3; k >= 0; k--)
		{
			tmp = (b[start + k] < 0) ? 256 + (int) (b[start + k]) : b[start + k];
			ret += (tmp << (8 * k));
		}
		return ret;
	}

	/**
	 * 将src的偏移位置为srcPos处开始的长度为length个字节的数据拷贝到sendBuf的sendBufOffset的位置处开始的地方进行存储		
	 * @param src
	 * @param srcPos
	 * @param length
	 */
	protected static void arrayCopyToSendBuf(Object src, int srcPos, int length)
	{
		System.arraycopy(src, srcPos, sendBuf, sendBufOffset, length);
		sendBufOffset += length;
	}

	/**
	 * 从recBuf中的recBufOffset偏移位置开始处拷贝长度为length个字节的数据存放到dst的dstPos位置开始处的地方
	 * @param dst
	 * @param dstPos
	 * @param length
	 */
	protected static void arrayCopyFromRecbuf(Object dst, int dstPos, int length)
	{
		System.arraycopy(recBuf, recBufOffset, dst, dstPos, length);
		recBufOffset += length;
	}

}
