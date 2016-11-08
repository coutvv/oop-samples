package ru.coutvv.oop.samples.vice.date;

public class PersonBeanImpl implements PersonBean {

	String Name, Interests, Gender;
	int hotOrNotRating = 0;
	int count = 0;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getInterests() {
		return Interests;
	}
	public void setInterests(String interests) {
		Interests = interests;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getHotOrNotRating() {
		return count == 0 ? 0 : hotOrNotRating / count;
	}
	public void setHotOrNotRating(int hotOrNotRating) {
		this.hotOrNotRating += hotOrNotRating; 
		count++;
	}
	public PersonBeanImpl(String name, String interests, String gender) {
		super();
		Name = name;
		Interests = interests;
		Gender = gender;
	}
}
