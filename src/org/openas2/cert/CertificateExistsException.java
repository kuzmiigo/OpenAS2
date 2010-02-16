package org.openas2.cert;

import org.openas2.OpenAS2Exception;

public class CertificateExistsException extends OpenAS2Exception {
	public CertificateExistsException(String alias) {
		super(alias);
	}
}
