package com.project.exportpdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.exportpdf.controller.Export;
import com.project.exportpdf.model.PDF;

@SpringBootApplication
public class ExportpdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExportpdfApplication.class, args);

		PDF pdf = new PDF(1, "Josué", null, "O animal foi perdido", "Cachorro",
				"https://www.newsrondonia.com.br/imagensNoticias/image/0(8156).jpg",
				"https://www.caminhoSiteAnimal.com");

		Export export = new Export();
		export.exportPDF(pdf);
	}

}
