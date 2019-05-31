package com.project.exportpdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.exportpdf.controller.RestExport;

@SpringBootApplication
public class ExportpdfApplication {

	public static void main(String[] args) {
		RestExport export = SpringApplication.run(ExportpdfApplication.class, args).getBean(RestExport.class);
		
		export.exportPDF(1, "Josué", null, "O animal foi perdido", "Cachorro",
				"https://www.newsrondonia.com.br/imagensNoticias/image/0(8156).jpg",
				"https://www.caminhoSiteAnimal.com");
		
		System.exit(0);
	}

}
