package ru.coutvv.oop.samples.vice.date.handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import ru.coutvv.oop.samples.vice.date.PersonBean;

public class NonOwnerInvocationHandler implements InvocationHandler {

	PersonBean person;

	public NonOwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if (method.getName().startsWith("get") || method.getName().equals("setHotOrNotRating")) {
			return method.invoke(person, args);
		} else if (method.getName().startsWith("set")) {
			throw new IllegalAccessException();
		}
		return null;
	}

}
