
package org.openas2.processor.receiver;

import org.openas2.message.AS2Message;
import org.openas2.message.Message;

public class AS2DirectoryPollingModule extends DirectoryPollingModule {

    protected Message createMessage() {        
        return new AS2Message();
    }

}
