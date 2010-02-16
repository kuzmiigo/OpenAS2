package org.openas2.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openas2.OpenAS2Exception;
import org.openas2.Session;

public class MultiCommand extends BaseCommand {
    private List cmds;

    public void init(Session session, Map parameters) throws OpenAS2Exception {
        super.init(session, parameters);
        getParameter(PARAM_NAME, true);
        getParameter(PARAM_DESCRIPTION, true);
        if (getUsage() == null) {
            setUsage(getName() + " <command> <parameters>");
        }
    }

    public Command getCommand(String name) {
        name = name.toLowerCase();

        List commands = getCommands();
        Command cmd;

        for (int i = 0; i < commands.size(); i++) {
            cmd = (Command) commands.get(i);

            if (cmd.getName().equals(name)) {
                return cmd;
            }
        }

        return null;
    }

    public List getCommands() {
        if (cmds == null) {
            cmds = new ArrayList();
        }

        return cmds;
    }

    public String getDescription(String name) {
        Command cmd = getCommand(name);

        if (cmd != null) {
            return cmd.getDescription();
        }

        return null;
    }

    public String getUsage(String name) {
        Command cmd = getCommand(name);

        if (cmd != null) {
            return cmd.getUsage();
        }

        return null;
    }

    public CommandResult execute(Object[] params) {
        if (params.length > 0) {
            String subName = params[0].toString();
            Command subCmd = getCommand(subName);

            if (subCmd != null) {
                List paramList = Arrays.asList(params);
                List subParams = new ArrayList(paramList);

                subParams.remove(0);

                return subCmd.execute(subParams.toArray());
            }
        }

        CommandResult listCmds = new CommandResult(CommandResult.TYPE_ERROR, "List of valid subcommands:");
        Iterator cmdIt = getCommands().iterator();
        Command currentCmd;

        while (cmdIt.hasNext()) {
            currentCmd = (Command) cmdIt.next();
            listCmds.getResults().add(currentCmd.getName());
        }

        return listCmds;
    }

    public CommandResult execute(String name, Object[] params) throws OpenAS2Exception {
        Command cmd = getCommand(name);

        if (cmd != null) {
            return cmd.execute(params);
        }
        throw new CommandException("Command doesn't exist: " + name);
    }

    public boolean supports(String name) {
        return getCommand(name) != null;
    }

    public String getDefaultName() {
        return null;
    }

    public String getDefaultDescription() {
        return null;
    }

    public String getDefaultUsage() {
        return null;
    }
}