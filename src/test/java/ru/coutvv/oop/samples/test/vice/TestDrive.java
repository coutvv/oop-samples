package ru.coutvv.oop.samples.test.vice;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Ignore;
import org.junit.Test;

import ru.coutvv.oop.samples.vice.GumballMachineImprove;
import ru.coutvv.oop.samples.vice.GumballMonitor;
import ru.coutvv.oop.samples.vice.machine.GumballMachineRemote;

/**
 * Перед запуском этого теста нужно запустить rmiregistry, 
 * 
 * Данный тест не работает :(( пока что
 * 
 * @author lomovtsevrs
 *
 */
public class TestDrive {
	
	/**
	 * Освобождаем названия сервисов на будущее 
	 * ибо при повторном запуске будут падать ошибки
	 * (потому что сервисы мертвы)
	 * 
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
//	@AfterClass
	public static void finished() throws AccessException, RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry();
		for(String loc : locations) {
			reg.unbind(loc);
		}
	}

	static String[] locations = {
			"shittyMachine", "superShittyMachine", "excellent"
	};
	
	@Ignore
	@Test
	public void test() throws RemoteException, NotBoundException {
		
		try {
			createRemoteGumballMachines();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
		try {
			printAllStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	private void printAllStatus() throws RemoteException, NotBoundException {
		for(String loc : locations) {
			print(loc);
		}
	}
	
	private void print(String name) throws RemoteException {
		if(hasRemotesMachines(name)) {
			GumballMonitor gm = new GumballMonitor(getGMR(name));
			gm.report();
		}
	}
	
	private boolean hasRemotesMachines(String name) {
		return getGMR(name) != null;
		
	}
	
	private GumballMachineRemote getGMR(String name) {
		GumballMachineRemote result = null;
		try {
			Registry reg = LocateRegistry.getRegistry();
			result = (GumballMachineRemote) reg.lookup(name);
		} catch (Exception e) {
			System.out.println("machine with name = " +name+" not found");
		}
		return result;
	}
	
	private void createRemoteGumballMachines() throws RemoteException, AlreadyBoundException {
		int count = 10;
		for(String loc : locations) {
			if(!hasRemotesMachines(loc)) {
				new GumballMachineImprove(count, loc); 
				count +=14;
			}
		}
	}
	
	
}
