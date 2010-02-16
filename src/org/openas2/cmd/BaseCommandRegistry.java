package org.openas2.cmd;

import java.util.ArrayList;
import java.util.List;

import org.openas2.BaseComponent;

public class BaseCommandRegistry extends BaseComponent implements CommandRegistry {
	private List commands;
	    
	public List getCommands() {
		if (commands == null) {
			commands = new ArrayList();
		}
		return commands;
	}

	public void setCommands(List commands) {
		this.commands = commands;
	}
	
}
