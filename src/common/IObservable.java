package common;

import java.rmi.Remote;

public interface IObservable extends Remote {

    public void removeObserver(Observer o);

    public void updateAllObservers();

    public void addObserver(Observer obs);
}
