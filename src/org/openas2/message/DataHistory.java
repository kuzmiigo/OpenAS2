package org.openas2.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.ContentType;


public class DataHistory implements Serializable {
    private List items;

    public List getItems() {
        if (items == null) {
            items = new ArrayList();
        }

        return items;
    }

    boolean contains(ContentType type) {
        Iterator itemIt = getItems().iterator();

        while (itemIt.hasNext()) {
            DataHistoryItem item = (DataHistoryItem) itemIt.next();

            if ((item.getContentType() != null) && item.getContentType().match(type)) {
                return true;
            }
        }

        return false;
    }
}
