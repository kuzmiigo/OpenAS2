package org.openas2.processor;

import java.util.Map;

import org.openas2.OpenAS2Exception;
import org.openas2.message.Message;


public class NoModuleException extends OpenAS2Exception {
    private Map options;
    private Message msg;
    private String action;

    public NoModuleException(String action, Message msg, Map options) {
        super(toString(action, msg, options));
        this.action = action;
        this.msg = msg;
        this.options = options;
    }

    public void setAction(String string) {
        action = string;
    }

    public String getAction() {
        return action;
    }

    public void setMsg(Message message) {
        msg = message;
    }

    public Message getMsg() {
        return msg;
    }

    public void setOptions(Map map) {
        options = map;
    }

    public Map getOptions() {
        return options;
    }

    public String toString() {
        return toString(getAction(), getMsg(), getOptions());
    }

    protected static String toString(String action, Message msg, Map options) {
        return "NoModuleException: Requested action: " + action + " Message: " + msg + " Options: " + options;
    }
}
