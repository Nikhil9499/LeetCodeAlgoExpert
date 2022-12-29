package observer;

/*
 *   Observer DP: It has 2 components, i.e, Observable & Observer
 *   Whenever any state change happens in observable, all the observer must be notified.(1:m)
 *   Application: notifyMe feature in Amazon, weather station temperature change to tv, mobiles, etc.
 *   Example: notifyMe for Iphone stocks whenever available.
 * */

import observer.observable.IphoneObservable;
import observer.observable.StockObservable;
import observer.observers.EmailNotificationObserver;
import observer.observers.NotificationObserver;
import observer.observers.SMSNotificationObserver;

public class Driver {
    public static void main(String[] args) {
        StockObservable iPhoneObservable = new IphoneObservable();

        NotificationObserver observable1 = new EmailNotificationObserver("nikhil@gmail.com", iPhoneObservable);
        NotificationObserver observable2 = new EmailNotificationObserver("nick@gmail.com", iPhoneObservable);
        NotificationObserver observable3 = new SMSNotificationObserver("8840208074", iPhoneObservable);

        iPhoneObservable.addObserver(observable1);
        iPhoneObservable.addObserver(observable2);
        iPhoneObservable.addObserver(observable3);

        iPhoneObservable.setStockCount(5);
    }
}
