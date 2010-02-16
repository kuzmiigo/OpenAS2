package org.openas2.app.cert;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.openas2.OpenAS2Exception;
import org.openas2.cert.AliasedCertificateFactory;
import org.openas2.cmd.CommandResult;

public class ListCertCommand extends AliasedCertCommand {
	public String getDefaultDescription() {
		return "List all certificate aliases in the current certificate store";
	}

	public String getDefaultName() {
		return "list";
	}

	public String getDefaultUsage() {
		return "list";
	}

	public CommandResult execute(AliasedCertificateFactory certFx,
			Object[] params) throws OpenAS2Exception {
		synchronized (certFx) {
			Map certs = certFx.getCertificates();
			Iterator certIt = certs.entrySet().iterator();
			Map.Entry currentCert;
			CommandResult cmdRes = new CommandResult(CommandResult.TYPE_OK);

			while (certIt.hasNext()) {
				currentCert = (Entry) certIt.next();
				cmdRes.getResults().add(currentCert.getKey().toString());
			}

			if (cmdRes.getResults().size() == 0) {
				cmdRes.getResults().add("No certificates available");
			}

			return cmdRes;

		}
	}
}
