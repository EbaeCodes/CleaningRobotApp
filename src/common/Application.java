package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Application extends Remote {
    public void startAutoMode() throws RemoteException;

}
