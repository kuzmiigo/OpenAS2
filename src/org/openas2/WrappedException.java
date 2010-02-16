package org.openas2;

public class WrappedException extends OpenAS2Exception {
    public WrappedException() {
        super();
    }

    public WrappedException(String msg) {
        super(msg);
    }

    public WrappedException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public WrappedException(Throwable cause) {
        super(cause);
    }

    public Exception getSource() {
        return (Exception) getCause();
    }

    public void rethrow() throws Exception {
        throw (Exception) getCause();
    }
}
