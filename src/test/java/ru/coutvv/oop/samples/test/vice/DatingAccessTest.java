package ru.coutvv.oop.samples.test.vice;

import org.junit.Test;

import ru.coutvv.oop.samples.vice.date.AccessController;
import ru.coutvv.oop.samples.vice.date.PersonBean;
import ru.coutvv.oop.samples.vice.date.PersonDB;

public class DatingAccessTest {

	@Test
	public void test() {
		PersonDB db = new PersonDB();
		PersonBean john = db.getPersonByName("John Snow");
		
		PersonBean ownerProxy = AccessController.getOwnerProxy(john);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("owner can\'t set self rating ");
		}
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());
		
		PersonBean nonOwnerProxy = AccessController.getNonOwnerProxy(john);
		System.out.println("Name is " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("pets and gay porn");
		} catch (Exception e) {
			System.out.println("non owner can\'t set self rating ");
		}
		nonOwnerProxy.setHotOrNotRating(10);
		System.out.println("John Rating is " + nonOwnerProxy.getHotOrNotRating());
		
		System.out.println("Rating for John is " + ownerProxy.getHotOrNotRating());
		
	}
}
