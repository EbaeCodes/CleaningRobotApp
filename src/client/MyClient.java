package client;

import java.rmi.Naming;

import common.Application;

public class MyClient {

    public static void main(String[] args) throws Exception {
	Application subject = (Application) Naming.lookup("rmi://127.0.0.1/subject");
	subject.startAutoMode();
    }

}
