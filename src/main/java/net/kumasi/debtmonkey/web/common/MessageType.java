/*
 * Created on 17 Feb 2017 ( Time 16:36:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.web.common;

public enum MessageType {
	
	SUCCESS,
	INFO,
	WARNING,
	DANGER;
	
	public String getCss() {
		return name().toLowerCase();
	}
	
}
