package ru.coutvv.oop.samples.vice.date;

import java.util.HashMap;
import java.util.Map;

public class PersonDB {

	Map<String, PersonBean> db = new HashMap<>();
	
	public PersonDB() {
		addToDb("John Snow","Night Watch","male");
		addToDb("Greg House","medicine","male");
		addToDb("Ostap Bender","visyuki","male");
		addToDb("Jesus Christ","your saving","male");
		addToDb("Jeanne D'ark","france independent","female");
		addToDb("Sveta From Ivanovo","Putin, krasivo odevat\'sa","female");
		addToDb("Hillary Clinton","Presidential Election","female");
		addToDb("Maria Magdalena","Jesus virginity","female");
	}
	
	private void addToDb(String name, String interests, String gender) {
		PersonBean pb = new PersonBeanImpl(name, interests, gender);
		db.put(name, pb);
	}
	
	public PersonBean getPersonByName(String name) {
		return db.get(name);
	}
}
