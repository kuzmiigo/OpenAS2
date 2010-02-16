package org.openas2.processor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openas2.OpenAS2Exception;


public class ProcessorException extends OpenAS2Exception {
	private Processor processor;
	private List causes;
	
	public ProcessorException(Processor processor) {
		super();
		this.processor = processor;
	}

	public List getCauses() {
		if (causes == null) {
			causes = new ArrayList();
		}
		return causes;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setCauses(List list) {
		causes = list;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	public String getMessage() {
		StringWriter strWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(strWriter);
		writer.print(super.getMessage());
		
		Iterator causesIt = getCauses().iterator();
		while (causesIt.hasNext()) {
			Exception e = (Exception) causesIt.next();
			writer.println();
			e.printStackTrace(writer);
			
		}
		writer.flush();
		return strWriter.toString();
	}

}
