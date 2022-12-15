package chainOfResponsibility;

public class InfoProcessor extends LogProcessor {

    public InfoProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void logRequest(int logLevel, String message) {
        if (logLevel == INFO) {
            System.out.println(message);
        } else {
            System.out.println("Unable to handle request @ INFO level. Going for the next processor");
            super.logRequest(logLevel, message);
        }
    }
}
