package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GeographicArea {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int geographicAreaID;
	
	@Column(name="code")
	private int code;
	
	@Column(name="level")
	private int level;
	
	@Column(name="name")
	private String name;
	
	@Column(name="combined")
	private int combined;
	
	public GeographicArea() {
		super();
	}

	public int getGeographicAreaID() {
		return geographicAreaID;
	}

	public void setGeographicAreaID(int geographicAreaID) {
		this.geographicAreaID = geographicAreaID;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCombined() {
		return combined;
	}

	public void setCombined(int combined) {
		this.combined = combined;
	}
}
