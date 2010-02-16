package org.openas2;

import java.util.HashMap;
import java.util.Map;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;

import org.openas2.cert.CertificateFactory;
import org.openas2.partner.PartnershipFactory;
import org.openas2.processor.Processor;


public abstract class BaseSession implements Session {
    private Map components;

    /**
     * Creates a <code>BaseSession</code> object, then calls the <code>init()</code> method.
     *
     * @throws OpenAS2Exception
     *
     * @see #init()
     */
    public BaseSession() throws OpenAS2Exception {
        init();
    }

    public CertificateFactory getCertificateFactory() throws ComponentNotFoundException {
        return (CertificateFactory) getComponent(CertificateFactory.COMPID_CERTIFICATE_FACTORY);
    }

    public void setComponent(String componentID, Component comp) {
        Map objects = getComponents();
        objects.put(componentID, comp);
    }

    public Component getComponent(String componentID) throws ComponentNotFoundException {
        Map comps = getComponents();
        Component comp = (Component) comps.get(componentID);

        if (comp == null) {
            throw new ComponentNotFoundException(componentID);
        }

        return comp;
    }

    public Map getComponents() {
        if (components == null) {
            components = new HashMap();
        }

        return components;
    }

    public PartnershipFactory getPartnershipFactory() throws ComponentNotFoundException {
        return (PartnershipFactory) getComponent(PartnershipFactory.COMPID_PARTNERSHIP_FACTORY);
    }

    public Processor getProcessor() throws ComponentNotFoundException {
        return (Processor) getComponent(Processor.COMPID_PROCESSOR);
    }

    /**
     * This method is called by the <code>BaseSession</code> constructor to set up any global
     * configuration settings.
     *
     * @throws OpenAS2Exception If an error occurs while initializing systems
     */
    protected void init() throws OpenAS2Exception {
        initJavaMail();
    }

    /**
     * Adds a group of content handlers to the Mailcap <code>CommandMap</code>. These handlers are
     * used by the JavaMail API to encode and decode information of specific mime types.
     *
     * @throws OpenAS2Exception If an error occurs while initializing mime types
     */
    protected void initJavaMail() throws OpenAS2Exception {
        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap(
            "message/disposition-notification;; x-java-content-handler=org.openas2.util.DispositionDataContentHandler");
        CommandMap.setDefaultCommandMap(mc);
    }
}
