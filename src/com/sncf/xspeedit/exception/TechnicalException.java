package com.sncf.xspeedit.exception;

/**
 * @author houhichi
 */
public class TechnicalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083817410008850479L;

	private final String code;
	private final String[] args;


	public TechnicalException(String msg) {
		super(msg);
		this.code = null;
		this.args = null;
	}


	public TechnicalException(String code, String msg) {
		super(msg);
		this.code = code;
		this.args = new String[] {};
	}


	public String getCode() {
		return code;
	}


	public String[] getArgs() {
		return args;
	}
}