package com.xc.lovesong.kernel.mail.domain;
public enum MailType {	
	IMG,FILE;
	/*
	 * IMG:图片类型;FILE:文件类型
	 */
	@Override
	public String toString() {
		String message = null;
		switch (this) {		
		case IMG :
			message = ",包含图片";
		default:
			message = ",包含附件";
			break;
		}
		return message;
	}
	
	

}
