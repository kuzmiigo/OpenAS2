package org.openas2.processor;

import org.openas2.WrappedException;


public class ForcedStopException extends WrappedException {
	public ForcedStopException(Exception source) {
		super(source);
	}
}
