package com.gospell.drm.drmman;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class InputStreamUtils {
	
	final static int BUFFER_SIZE = 4096;
	
	/**
	 * @param in InputStream
	 * @return String
	 * @throws Exception
	 * 
	 */
	public static String InputStreamTOString(InputStream in) throws Exception{
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while((count = in.read(data,0,BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);
		
		data = null;
		return new String(outStream.toByteArray(),"ISO-8859-1");
	}
	
	/**
	 * @param in
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
         public static String InputStreamTOString(InputStream in,String encoding) throws Exception{
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while((count = in.read(data,0,BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);
		
		data = null;
		return new String(outStream.toByteArray(),"ISO-8859-1");
	}
    
    /**
     * @param in
     * @return
     * @throws Exception
     */
    public static InputStream StringTOInputStream(String in) throws Exception{
    	
    	ByteArrayInputStream is = new ByteArrayInputStream(in.getBytes("ISO-8859-1"));
    	return is;
    }
    
    /**
     * @param in InputStream
     * @return byte[]
     * @throws IOException
     */
    public static byte[] InputStreamTOByte(InputStream in) throws IOException{
    	
    	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while((count = in.read(data,0,BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);
		
		data = null;
		return outStream.toByteArray();
    }
    
    /**
     * @param in
     * @return
     * @throws Exception
     */
    public static InputStream byteTOInputStream(byte[] in) throws Exception{
    	
    	ByteArrayInputStream is = new ByteArrayInputStream(in);
    	return is;
    }
    
    /**
     * @param in
     * @return
     * @throws Exception
     */
    public static String byteTOString(byte[] in) throws Exception{
    	
    	InputStream is = byteTOInputStream(in);
    	return InputStreamTOString(is);
    }

}