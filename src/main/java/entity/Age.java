package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Age {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ageID;
	
	@Column(name="censusYear")
	private int censusYear;
	
	@Column(name="male")
	private int male;
	
	@Column(name="female")
	private int female;
	
	public Age() {
		super();
	}

	public int getAgeID() {
		return ageID;
	}

	public void setAgeID(int ageID) {
		this.ageID = ageID;
	}

	public int getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(int censusYear) {
		this.censusYear = censusYear;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public int getFemale() {
		return female;
	}

	public void setFemale(int female) {
		this.female = female;
	}
}
