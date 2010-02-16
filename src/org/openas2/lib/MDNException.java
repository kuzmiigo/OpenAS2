package org.openas2.lib;

public class MDNException extends OpenAS2Exception {
	public MDNException() {
		super();		
	}

	public MDNException(String msg) {
		super(msg);
	}

	public MDNException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MDNException(Throwable cause) {
		super(cause);
	}
}
