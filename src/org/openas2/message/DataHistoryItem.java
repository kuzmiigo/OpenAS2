package org.openas2.message;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.ContentType;
import javax.mail.internet.ParseException;


public class DataHistoryItem implements Serializable {
    private ContentType contentType;
    private Map attributes;

    public DataHistoryItem(ContentType type) {
        super();
        setContentType(type);
    }

    public DataHistoryItem(String contentType) throws ParseException {
        super();
        setContentType(contentType);
    }

    public Map getAttributes() {
        if (attributes == null) {
            attributes = new HashMap();
        }

        return attributes;
    }

    public void setContentType(ContentType type) {
        contentType = type;
    }

    public void setContentType(String type) throws ParseException {
        setContentType(new ContentType(type));
    }

    public ContentType getContentType() {
        return contentType;
    }

    private void readObject(java.io.ObjectInputStream in)
        throws ParseException, IOException, ClassNotFoundException {
        contentType = new ContentType((String) in.readObject());

        attributes = (Map) in.readObject();
    }

    private void writeObject(java.io.ObjectOutputStream out)
        throws IOException {
        out.writeObject(contentType.toString());
        out.writeObject(attributes);
    }
}
