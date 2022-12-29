package observer.observers;

import observer.observable.StockObservable;

public class EmailNotificationObserver implements NotificationObserver {

    private final String emailId;
    private final StockObservable stockObservable;

    public EmailNotificationObserver(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail(emailId, stockObservable.getStockCount() + " new stocks are available. Hurry up and buy it before it's gone!!!!");
    }

    private void sendEmail(String email, String message) {
        System.out.println("Mail sent to " + email + " with body = " + message);
    }
}
