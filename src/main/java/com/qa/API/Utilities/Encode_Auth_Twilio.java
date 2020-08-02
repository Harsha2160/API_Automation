package com.qa.API.Utilities;

import org.apache.commons.codec.binary.Base64;

import com.qa.API.Base.BaseClass;

public class Encode_Auth_Twilio extends BaseClass {


	public static String Auth_Encode() {
		String Account_SID=prop.getProperty("Account_SID");
		String AuthToken=prop.getProperty("AuthToken");
		String authCredentials = Account_SID + ":" + AuthToken;
		byte[] authEncBytes = Base64.encodeBase64(authCredentials.getBytes());
		String authStringEnc = new String(authEncBytes);
		String authString="Basic"+" "+authStringEnc;
		return authString;
		
	}

}
