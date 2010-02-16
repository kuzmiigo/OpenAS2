package org.openas2.processor;

import org.openas2.OpenAS2Exception;

public class UnsupportedException extends OpenAS2Exception {
	public UnsupportedException() {
		super();
	}

	public UnsupportedException(String msg) {
		super(msg);
	}
}
