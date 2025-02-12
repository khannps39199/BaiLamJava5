package poly.edu.Entity.Lab2;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;
import lombok.Builder;
import lombok.Builder.Default;

@Data
@Builder
public class Staff {
	private String id;
	private String fullname;
	@Default
	private String photo = "photo.jpg";
	@Default
	private boolean gender=true;
	@Default
	private LocalDate birthday=LocalDate.of(2005, 9, 26);
	@Default
	private int age=0;
	@Default
	private double salary=123456.789;
	@Default
	private int level=1;
	public Staff(String id, String fullname, String photo, boolean gender, LocalDate birthday, double salary, int level) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.photo = photo;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
		this.level = level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhoto() {
		return photo;
	}
	public int getAge() {
		LocalDate date=LocalDate.now();
		return date.getYear()-getBirthday().getYear();
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
