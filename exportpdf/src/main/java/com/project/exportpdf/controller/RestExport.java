package com.project.exportpdf.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.exportpdf.model.PDF;

/**
 * @author gamota
 *
 */

@Component
public class RestExport {

	private RestTemplate restTemplate;
	private String url;

	public RestExport() {
		restTemplate = new RestTemplate();
		url = "http://localhost:8080/exportpdf/";
	}

	public void exportPDF(int animalID, String animalName, Date lostDate, String animalInfos, String animalType,
			String animalImgPath, String animalSitePath) {
		PDF pdf = new PDF(animalID, animalName, lostDate, animalInfos, animalType, animalImgPath, animalSitePath);
		ResponseEntity<String> answer = this.restTemplate.postForEntity(url, pdf, String.class);

		System.out.println(answer);
	}
}
