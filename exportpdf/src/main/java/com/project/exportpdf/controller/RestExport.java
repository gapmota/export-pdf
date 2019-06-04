package com.project.exportpdf.controller;

import java.util.Date;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.project.exportpdf.model.PDF;

/**
 * @author gamota
 *
 */


public class RestExport {

	@PostMapping
	public void exportPDF(@RequestBody InfoPet pet) {
		PDF pdf = new PDF(pet.animalID, pet.animalName, pet.lostDate, pet.animalInfos, pet.animalType, pet.animalImgPath, pet.animalSitePath);
	}
}

class InfoPet {
    int animalID;
	String animalName;
	 Date lostDate;
	 String animalInfos;
	 String animalType;
	 String animalImgPath;
	 String animalSitePath;
}
