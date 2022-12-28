package chainOfResponsibility;

public class DebugProcessor extends LogProcessor {
    public DebugProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void logRequest(int logLevel, String message) {
        if (logLevel == DEBUG) {
            System.out.println(message);
        } else {
            System.out.println("Unable to handle request @ DEBUG level. Going for the next processor");
            super.logRequest(logLevel, message);
        }
    }
}
