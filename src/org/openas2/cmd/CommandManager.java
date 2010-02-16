package org.openas2.cmd;

import java.util.ArrayList;
import java.util.List;

import org.openas2.cmd.processor.BaseCommandProcessor;

/**
 * command calls the registered command processors
 * 
 * @author joseph mcverry
 *
 */
public class CommandManager {
	private static CommandManager defaultManager;
	private List processors;

	public static CommandManager getCmdManager() {
		if (defaultManager == null) {
			defaultManager = new CommandManager();
		}

		return defaultManager;
	}

	public void setProcessors(List listeners) {
		this.processors = listeners;
	}

	public List getProcessors() {
		if (processors == null) {
			processors = new ArrayList();
		}

		return processors;
	}

	public void addProcessor(BaseCommandProcessor processor) {
		List processors = getProcessors();
		processors.add(processor);
	}

}
