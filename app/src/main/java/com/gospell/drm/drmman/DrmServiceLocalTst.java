package com.gospell.drm.drmman;

public class DrmServiceLocalTst {
	
	public static native int Login(String sUsername,String sPwd,String sRiUrl); 
	public static native String P4Query(String sCid); 
	public static native String P5LicenseRequest(String sXmlRos); 
	public static native String P6DoAction(String sCid, int eActionType); 
	public static native String P7CanDoAction(String sCid, int eActionType); 
	public static native byte[] P8SendData(byte[] pSendBuf
		, int nSendLen, int eEncryptionMethod);
	public static native byte[] P8SendDataTo(byte[] pSendBuf
		, int nSendLen, int eEncryptionMethod, String sUrl);
	
    static {
    	System.loadLibrary("DrmService");
    }

	public enum EncryptionMethod{ENCRYPTION_UNKNOWN,ENCRYPTION_NONE,ENCRYPTION_DASTANDARD}

}
