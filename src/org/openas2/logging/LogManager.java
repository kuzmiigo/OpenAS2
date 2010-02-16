package org.openas2.logging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openas2.OpenAS2Exception;



public class LogManager {
    private static LogManager defaultManager;
    private List loggers;

    public static LogManager getLogManager() {
        if (defaultManager == null) {
            defaultManager = new LogManager();
        }

        return defaultManager;
    }
    
    private static boolean registedWithApache = false;

    public void setLoggers(List listeners) {
        this.loggers = listeners;
    }

    public List getLoggers() {
        if (loggers == null) {
            loggers = new ArrayList();
        }

        return loggers;
    }

    public void addLogger(Logger logger) {
        List loggers = getLoggers();
        loggers.add(logger);
    }

    public void log(OpenAS2Exception e, boolean terminated) {
        Iterator loggerIt = getLoggers().iterator();

        if (loggerIt.hasNext()) {
            while (loggerIt.hasNext()) {
                Logger logger = (Logger) loggerIt.next();
                logger.log(e, terminated);
            }
        } else {
            e.printStackTrace();
        }
    }

    /**
     * @param level
     * @param msg
     */
    public void log(Level level, String msg) {
        Iterator loggerIt = getLoggers().iterator();

        if (loggerIt.hasNext()) {
            while (loggerIt.hasNext()) {
                Logger logger = (Logger) loggerIt.next();
                logger.log(level, msg, null);
            }
        } else {
            System.out.println(level.getName() + " " + msg);
        }
    }

    ArrayList requestors = new ArrayList();
	/**
	 * @param log
	 */
	public void addRequstors(String inName) {
		requestors.add(inName);
		setRegistedWithApache(true);
	}

	/**
	 * @param registedWithApache the registedWithApache to set
	 */
	public static void setRegistedWithApache(boolean registedWithApache) {
		LogManager.registedWithApache = registedWithApache;
	}

	/**
	 * @return the registedWithApache
	 */
	public static boolean isRegistedWithApache() {
		return registedWithApache;
	}
    
    
    
    
}
