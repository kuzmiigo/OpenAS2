package org.openas2.processor;

import java.util.List;
import java.util.Map;

import org.openas2.Component;
import org.openas2.OpenAS2Exception;
import org.openas2.message.Message;

public interface Processor extends Component {
	public static final String COMPID_PROCESSOR = "processor";
	
	public void handle(String action, Message msg, Map options) throws OpenAS2Exception;	
	public List getModules();
	public void setModules(List modules);
	
	public void startActiveModules();
	public void stopActiveModules();
	public List getActiveModules();
}
