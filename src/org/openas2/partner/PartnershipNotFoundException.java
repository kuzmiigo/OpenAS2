package org.openas2.partner;

import org.openas2.OpenAS2Exception;

public class PartnershipNotFoundException extends OpenAS2Exception {

    public PartnershipNotFoundException(String msg) {
        super(msg);
    }

    public PartnershipNotFoundException(Partnership p) {
        super("Partnership not found: " + p);        
    }

}
