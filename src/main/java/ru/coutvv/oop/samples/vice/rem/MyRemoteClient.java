package ru.coutvv.oop.samples.vice.rem;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClient {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry();
			MyRemote stub = (MyRemote) reg.lookup("MyRemote");
			String resp = stub.sayHello();
			System.out.println("Response: " + resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
