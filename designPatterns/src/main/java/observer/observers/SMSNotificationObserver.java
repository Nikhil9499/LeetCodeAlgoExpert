package observer.observers;

import observer.observable.StockObservable;

public class SMSNotificationObserver implements NotificationObserver {

    private final String mobileNumber;
    private final StockObservable stockObservable;

    public SMSNotificationObserver(String mobileNumber, StockObservable stockObservable) {
        this.mobileNumber = mobileNumber;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendSMS(mobileNumber, stockObservable.getStockCount() + " new stocks are available. Hurry up and buy it before it's gone!!!!");
    }

    private void sendSMS(String mobileNumber, String message) {
        System.out.println("SMS sent to " + mobileNumber + " with body = " + message);
    }
}
