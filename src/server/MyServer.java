package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

import common.Application;

public class MyServer {

    public static void startRegistry() throws Exception {
	LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
	RemoteServer.setLog(System.err);
    }

    public static void main(String[] args) throws Exception {
	startRegistry();
	RemoteServer.setLog(System.err);
	Application subject = new ApplicationImpl();
	Naming.rebind("subject", subject);
	System.out.println("Server is ready");
    }
}
