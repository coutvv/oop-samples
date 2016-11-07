package ru.coutvv.oop.samples.vice.machine;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ru.coutvv.oop.samples.state.states.State;

public interface GumballMachineRemote extends Remote {

	int getCount() throws RemoteException;
	String getLocation() throws RemoteException;
	public State getState() throws RemoteException;
}
