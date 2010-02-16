package org.openas2;

import java.util.Map;


/**
 * The <code>Component</code> interface provides a standard way to dynamically create and
 * initialize an object. <code>Component</code>-based objects also have access to a
 * <code>Session</code>, which allow each component to access all components  registered to it's
 * <code>Session</code>.   Parameters for a component are defined as static strings   Note: Any
 * object that implements this interface must have a constructor with  no parameters, as these
 * parameters should be passed to the <code>init</code>  method.
 *
 * @author Aaron Silinskas
 *
 * @see BaseComponent
 * @see Session
 */
public interface Component {
    /**
     * Returns a name for the component. These names are not guaranteed to  be unique, and are
     * intended for display and logging. Generally this is the class name of the
     * <code>Component</code> object, without package  information.
     *
     * @return name of the component
     */
    public String getName();

    /**
     * Returns the parameters used to initialize this <code>Component</code>, and can also be used
     * to modify parameters.
     *
     * @return map of parameter name to parameter value
     */
    public Map getParameters();

    /**
     * Returns the <code>Session</code> used to initialize this <code>Component</code>. The
     * returned session is also used to locate other components if needed.
     *
     * @return this component's session
     */
    public Session getSession();

    /**
     * After creating a <code>Component</code> object, this method should be called to set any
     * parameters used by the component. <code>Component</code> implementations typically have
     * required parameter checking and code to start timers and threads within this method.
     *
     * @param session the component uses this object to access other components
     * @param parameters configuration values for the component
     *
     * @throws OpenAS2Exception If an error occurs while initializing the component
     * @throws InvalidParameterException If a required parameter is null in the parameters
     *         <code>Map</code>
     *
     * @see #getParameter(String key, boolean required)
     * @see Session
     */
    public void init(Session session, Map parameters) throws OpenAS2Exception;
}
