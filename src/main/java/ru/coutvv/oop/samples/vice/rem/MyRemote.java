package ru.coutvv.oop.samples.vice.rem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Паттерн Заместитель предоставляет суррогатный 
 * объект управляющий доступом к другому объекту
 *  
 * @author lomovtsevrs
 */
public interface MyRemote extends Remote {
	String sayHello() throws RemoteException;
}
