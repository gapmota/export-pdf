package com.project.exportpdf.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.exportpdf.model.PDF;

/**
 * @author gamota
 *
 */

@RestController
@RequestMapping("/exportpdf")
public class RestExport {

	private final static String url = "http://localhost:8080/exportpdf/";
	
	private RestTemplate restTemplate;

	public RestExport() {
		restTemplate = new RestTemplate();
	}

	@PostMapping
	public void exportPDF(int animalID, String animalName, Date lostDate, String animalInfos, String animalType,
			String animalImgPath, String animalSitePath) {
		PDF pdf = new PDF(animalID, animalName, lostDate, animalInfos, animalType, animalImgPath, animalSitePath);
		ResponseEntity<String> answer = this.restTemplate.postForEntity(url, pdf, String.class);

		System.out.println(answer);
	}
}
