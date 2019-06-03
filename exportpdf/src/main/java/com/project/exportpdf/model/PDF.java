package com.project.exportpdf.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author gamota
 *
 */

public class PDF {
	@JsonProperty
	private int animalID;
	@JsonProperty
	private String animalName;
	@JsonProperty
	private Date lostDate;
	@JsonProperty
	private String animalInfos;
	@JsonProperty
	private String animalType;
	@JsonProperty
	private String animalImgPath;
	@JsonProperty
	private String animalSitePath;

	public PDF(int animalID, String animalName, Date lostDate, String animalInfos, String animalType,
			String animalImgPath, String animalSitePath) {
		this.animalID = animalID;
		this.animalName = animalName;
		this.lostDate = lostDate;
		this.animalInfos = animalInfos;
		this.animalType = animalType;
		this.animalImgPath = animalImgPath;
		this.animalSitePath = animalSitePath;
	}

	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public Date getLostDate() {
		return lostDate;
	}

	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}

	public String getAnimalInfos() {
		return animalInfos;
	}

	public void setAnimalInfos(String animalInfos) {
		this.animalInfos = animalInfos;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalImgPath() {
		return animalImgPath;
	}

	public void setAnimalImgPath(String animalImgPath) {
		this.animalImgPath = animalImgPath;
	}

	public String getAnimalSitePath() {
		return animalSitePath;
	}

	public void setAnimalSitePath(String animalSitePath) {
		this.animalSitePath = animalSitePath;
	}

	@Override
	public String toString() {
		return "PDF [animalID=" + animalID + ", animalName=" + animalName + ", lostDate=" + lostDate + ", animalInfos="
				+ animalInfos + ", animalType=" + animalType + ", animalImgPath=" + animalImgPath + ", AnimalSitePath="
				+ animalSitePath + "]";
	}

}
