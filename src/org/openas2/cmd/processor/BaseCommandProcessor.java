package org.openas2.cmd.processor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openas2.Component;
import org.openas2.OpenAS2Exception;
import org.openas2.Session;
import org.openas2.cmd.Command;
import org.openas2.cmd.CommandRegistry;


public abstract class BaseCommandProcessor extends Thread implements CommandProcessor, Component {

	public Map getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(Session session, Map parameters) throws OpenAS2Exception {
		// TODO Auto-generated method stub
		
	}

	private List commands;
    private boolean terminated;

    public BaseCommandProcessor() {
        super();
        terminated = false;
    }

    public void setCommands(List list) {
        commands = list;
    }

    public List getCommands() {
        if (commands == null) {
            commands = new ArrayList();
        }

        return commands;
    }
	
	public Command getCommand(String name) {
		Command currentCmd;
		Iterator commandIt = getCommands().iterator();
		while (commandIt.hasNext()) {
			currentCmd = (Command) commandIt.next();
			if (currentCmd.getName().equals(name)) {
				return currentCmd;
			}
		}
		return null;
	}
	
    public boolean isTerminated() {
        return terminated;
    }

    public void processCommand() throws OpenAS2Exception {
    	throw new OpenAS2Exception("super class method call, not initialized correctly");
    }
    
    public void addCommands(CommandRegistry reg) {
        ;

        List regCmds = reg.getCommands();

        if (regCmds.size() > 0) {
            getCommands().addAll(regCmds);
        }
    }

    public void terminate() {
        terminated = true;
    }
}
