package observer.observable;

import observer.observers.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class XiomiObservable implements StockObservable {

    private final List<NotificationObserver> xiomiNotificationObservers = new ArrayList<>();
    private final int xiomiStockCount = 0;

    @Override
    public void addObserver(NotificationObserver notificationObserver) {

    }

    @Override
    public void removeObserver(NotificationObserver notificationObserver) {

    }

    @Override
    public void notifyAllObservers() {

    }

    @Override
    public int getStockCount() {
        return 0;
    }

    @Override
    public void setStockCount(int newStockCount) {

    }
}
