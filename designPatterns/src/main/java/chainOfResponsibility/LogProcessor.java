package chainOfResponsibility;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    public static int WARN = 4;

    private LogProcessor next;
    public LogProcessor(LogProcessor next) {
        this.next = next;
    }

    public LogProcessor getNext() {
        return next;
    }

    public void setNext(LogProcessor next) {
        this.next = next;
    }

    public void logRequest(int logLevel, String message) {
        if (next != null) {
            next.logRequest(logLevel, message);
        } else {
            System.out.println("Unable to log request for logLevel " + logLevel);
        }
    }
}
