package com.project.exportpdf.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty
	private String ownerName;
	@JsonProperty
	private String ownerEmail;
	@JsonProperty
	private String ownerNumber;
	@JsonProperty
	private String howWasLost;
	@JsonProperty
	private String cepLost;

	public PDF(int animalID, String animalName, Date lostDate, String animalInfos, String animalType,
			String animalImgPath, String animalSitePath, String ownerName, String ownerEmail, String ownerNumber,
			String howWasLost, String cepLost) {
		this.animalID = animalID;
		this.animalName = animalName;
		this.lostDate = lostDate;
		this.animalInfos = animalInfos;
		this.animalType = animalType;
		this.animalImgPath = animalImgPath;
		this.animalSitePath = animalSitePath;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.ownerNumber = ownerNumber;
		this.howWasLost = howWasLost;
		this.cepLost = cepLost;
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

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerNumber() {
		return ownerNumber;
	}

	public void setOwnerNumber(String ownerNumber) {
		this.ownerNumber = ownerNumber;
	}

	public String getHowWasLost() {
		return howWasLost;
	}

	public void setHowWasLost(String howWasLost) {
		this.howWasLost = howWasLost;
	}

	public String getCepLost() {
		return cepLost;
	}

	public void setCepLost(String cepLost) {
		this.cepLost = cepLost;
	}

	@Override
	public String toString() {
		return "InfoPet [animalID=" + animalID + ", animalName=" + animalName + ", lostDate=" + lostDate
				+ ", animalInfos=" + animalInfos + ", animalType=" + animalType + ", animalImgPath=" + animalImgPath
				+ ", animalSitePath=" + animalSitePath + ", ownerName=" + ownerName + ", ownerEmail=" + ownerEmail
				+ ", ownerNumber=" + ownerNumber + ", ownerNumber=" + ownerNumber + ", howWasLost=" + howWasLost
				+ ", cepLost=" + cepLost + "]";
	}

}
