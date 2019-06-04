package com.project.exportpdf.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.exportpdf.model.Export;
import com.project.exportpdf.model.PDF;

@CrossOrigin
@RestController
@RequestMapping("/exportpdf")
public class RestExport {

	@PostMapping
	public void exportPDF(@RequestBody InfoPet pet) {
		pet.setAnimalImgPath("https://pbs.twimg.com/media/De9tDBUWAAABVxn.jpg");
		pet.setAnimalSitePath("lospets.azurewebsites.net/lost/27");
		PDF pdf = new PDF(pet.getAnimalID(), pet.getAnimalName(), pet.getLostDate(), pet.getAnimalInfos(),
				pet.getAnimalType(), pet.getAnimalImgPath(), pet.getAnimalSitePath());
		Export arq = new Export();

		arq.exportPDF(pdf);
	}
}

class InfoPet {

	private int animalID;
	private String animalName;
	private Date lostDate;
	private String animalInfos;
	private String animalType;
	private String animalImgPath;
	private String animalSitePath;

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
		return "InfoPet [animalID=" + animalID + ", animalName=" + animalName + ", lostDate=" + lostDate
				+ ", animalInfos=" + animalInfos + ", animalType=" + animalType + ", animalImgPath=" + animalImgPath
				+ ", animalSitePath=" + animalSitePath + "]";
	}

}
