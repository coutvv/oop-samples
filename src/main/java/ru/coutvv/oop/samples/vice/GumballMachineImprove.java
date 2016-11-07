package ru.coutvv.oop.samples.vice;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import ru.coutvv.oop.samples.state.GumballMachine;
import ru.coutvv.oop.samples.vice.machine.GumballMachineRemote;

public class GumballMachineImprove extends GumballMachine implements GumballMachineRemote {

	@Override
	public int getCount() throws RemoteException {
		
		return count;
	}

	@Override
	public String getLocation() throws RemoteException {
		return locaion;
	}

	public GumballMachineImprove(int count, String location) throws RemoteException, AlreadyBoundException {
		super(count);
		this.locaion = location;
		createRMIService();
	}
	
	private void createRMIService() throws RemoteException, AlreadyBoundException {
		GumballMachineRemote stub = (GumballMachineRemote) UnicastRemoteObject.exportObject(this, 0);
		Registry reg = LocateRegistry.getRegistry();
		reg.bind(locaion, stub);
	}
	
	String locaion;
	
}
