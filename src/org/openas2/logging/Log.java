/**
 * 
 */
package org.openas2.logging;

import org.openas2.OpenAS2Exception;

/**
 * @author joseph mcverry
 *
 */
public class Log implements org.apache.commons.logging.Log {
	
	LogManager lm;
	
	String clazzname;
	
	public Log(String inName) {
		
		lm = LogManager.getLogManager();
		lm.addRequstors(inName);
		clazzname=inName;
		
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#debug(java.lang.Object)
	 */
	public void debug(Object message) {
		lm.log(Level.FINE, clazzname+": "+message.toString());

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#debug(java.lang.Object, java.lang.Throwable)
	 */
	public void debug(Object message, Throwable t) {
		lm.log(Level.FINE, clazzname+": "+message.toString());
		lm.log((OpenAS2Exception) t, false);

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#error(java.lang.Object)
	 */
	public void error(Object message) {
		lm.log(Level.ERROR, clazzname+": "+message.toString());

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#error(java.lang.Object, java.lang.Throwable)
	 */
	public void error(Object message, Throwable t) {
		lm.log(Level.ERROR, clazzname+": "+message.toString());
		lm.log((OpenAS2Exception) t, false);

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#fatal(java.lang.Object)
	 */
	public void fatal(Object message) {
		lm.log(Level.ERROR, clazzname+": "+message.toString());

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#fatal(java.lang.Object, java.lang.Throwable)
	 */
	public void fatal(Object message, Throwable t) {
		lm.log(Level.ERROR, clazzname+": "+message.toString());
		lm.log((OpenAS2Exception) t, true);

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#info(java.lang.Object)
	 */
	public void info(Object message) {
		lm.log(Level.FINE, clazzname+": "+message.toString());

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#info(java.lang.Object, java.lang.Throwable)
	 */
	public void info(Object message, Throwable t) {
		lm.log(Level.FINE, clazzname+": "+message.toString());
		lm.log((OpenAS2Exception) t, false);

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#isErrorEnabled()
	 */
	public boolean isErrorEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#isFatalEnabled()
	 */
	public boolean isFatalEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#isInfoEnabled()
	 */
	public boolean isInfoEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#isTraceEnabled()
	 */
	public boolean isTraceEnabled() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#isWarnEnabled()
	 */
	public boolean isWarnEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#trace(java.lang.Object)
	 */
	public void trace(Object message) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#trace(java.lang.Object, java.lang.Throwable)
	 */
	public void trace(Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#warn(java.lang.Object)
	 */
	public void warn(Object message) {
		lm.log(Level.WARNING, clazzname+": "+message.toString());

	}

	/* (non-Javadoc)
	 * @see org.apache.commons.logging.Log#warn(java.lang.Object, java.lang.Throwable)
	 */
	public void warn(Object message, Throwable t) {
		lm.log(Level.WARNING, clazzname+": "+message.toString());
		lm.log((OpenAS2Exception) t, false);

	}

}
