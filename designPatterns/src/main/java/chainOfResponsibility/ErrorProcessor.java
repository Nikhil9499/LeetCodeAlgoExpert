package chainOfResponsibility;

public class ErrorProcessor extends LogProcessor {
    public ErrorProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void logRequest(int logLevel, String message) {
        if (logLevel == ERROR) {
            System.out.println(message);
        } else {
            System.out.println("Unable to handle request @ ERROR level. Going for the next processor");
            super.logRequest(logLevel, message);
        }
    }
}
