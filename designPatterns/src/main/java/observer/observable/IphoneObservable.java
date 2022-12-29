package observer.observable;

import observer.observers.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable {

    private final List<NotificationObserver> iPhoneNotificationObservers = new ArrayList<>();
    private int iphoneStockCount = 0;

    @Override
    public void addObserver(NotificationObserver notificationObserver) {
        iPhoneNotificationObservers.add(notificationObserver);
    }

    @Override
    public void removeObserver(NotificationObserver notificationObserver) {
        iPhoneNotificationObservers.remove(notificationObserver);
    }

    @Override
    public void notifyAllObservers() {
        for (NotificationObserver notificationObserver : iPhoneNotificationObservers) {
            notificationObserver.update();
        }
    }

    @Override
    public int getStockCount() {
        return iphoneStockCount;
    }

    @Override
    public void setStockCount(int newStockCount) {
        // Setting new stock count, if it was 0 before it will notify all subscribers who clicked on notifyMe
        // when new stock is available
        boolean isNewStockAvailable = iphoneStockCount == 0;
        iphoneStockCount += newStockCount;
        if (isNewStockAvailable) {
            notifyAllObservers();
        }
        System.out.println("New Stock count is " + iphoneStockCount);
    }
}
