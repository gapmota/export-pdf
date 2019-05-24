package com.project.exportpdf.model;

import java.util.Date;

/**
 * @author gamota
 *
 */

public class PDF {
	private int animalID;
	private String animalName;
	private Date lostDate;
	private String animalInfos;
	private String animalType;
	private String animalImgPath;
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

}
