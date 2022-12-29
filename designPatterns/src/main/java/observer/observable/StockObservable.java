package observer.observable;

import observer.observers.NotificationObserver;

public interface StockObservable {
    void addObserver(NotificationObserver notificationObserver);

    void removeObserver(NotificationObserver notificationObserver);

    void notifyAllObservers();

    int getStockCount();

    void setStockCount(int newStockCount);
}
