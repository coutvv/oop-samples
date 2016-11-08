package ru.coutvv.oop.samples.vice.date;

import java.lang.reflect.Proxy;

import ru.coutvv.oop.samples.vice.date.handlers.NonOwnerInvocationHandler;
import ru.coutvv.oop.samples.vice.date.handlers.OwnerInvocationHandler;

public class AccessController {

	public static PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance( person.getClass().getClassLoader(), 
													person.getClass().getInterfaces(), 
													new OwnerInvocationHandler(person)
				);
	}
	
	public static PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance( person.getClass().getClassLoader(), 
													person.getClass().getInterfaces(), 
													new NonOwnerInvocationHandler(person)
				);
	}
}
