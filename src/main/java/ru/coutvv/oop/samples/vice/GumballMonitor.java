package ru.coutvv.oop.samples.vice;

import java.rmi.RemoteException;

import ru.coutvv.oop.samples.vice.machine.GumballMachineRemote;

public class GumballMonitor {

	GumballMachineRemote remote;
	
	public GumballMonitor(GumballMachineRemote gmi) {
		this.remote = gmi;
	}
	
	public void report() throws RemoteException {
		
		try {
			System.out.println("Gumball Machine I: " + remote.getLocation());
			System.out.println("count: " +remote.getCount() );
			System.out.println(remote.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
