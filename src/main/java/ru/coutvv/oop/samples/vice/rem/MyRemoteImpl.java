package ru.coutvv.oop.samples.vice.rem;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl implements MyRemote {

	protected MyRemoteImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello() throws RemoteException {
		System.out.println("stupid client demand to say hello");
		return "Server says, \'Hey!\'";
	}

	public static void main(String[] args) {
		try {
			MyRemoteImpl obj = new MyRemoteImpl();
			MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(obj, 0);
			
			Registry reg = LocateRegistry.getRegistry();
			reg.bind("MyRemote", stub);
			System.err.println("Server ready");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}
}
