package chainOfResponsibility;

public class Driver {
    public static void main(String[] args) {
        LogProcessor log = new InfoProcessor(new DebugProcessor(new ErrorProcessor(null)));
        log.logRequest(LogProcessor.ERROR, "Error message test");
        log.logRequest(LogProcessor.DEBUG, "Debug message test");
        log.logRequest(LogProcessor.INFO, "Info message test");
        log.logRequest(LogProcessor.WARN, "Warn message test");
    }
}
