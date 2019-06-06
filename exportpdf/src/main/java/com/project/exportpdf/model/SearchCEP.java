package com.project.exportpdf.model;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchCEP {

	private String CEP;

	public SearchCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getAdress() throws IOException {
		try {

			Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
			Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
			for (Element urlEndereco : urlPesquisa) {
				return urlEndereco.text();
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		}
		return CEP;
	}

	public String getDistrict() throws IOException {
		try {

			Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
			Elements urlSearch = doc.select("td:gt(1)");
			for (Element urlDistrict : urlSearch) {
				return urlDistrict.text();
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		}
		return CEP;
	}

	public String getCity() throws IOException {
		try {

			Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
			Elements urlSearch = doc.select("span[itemprop=addressLocality]");
			for (Element urlCity : urlSearch) {
				return urlCity.text();
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		}
		return CEP;
	}

	public String getUF() throws IOException {
		try {

			Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
			Elements urlSearch = doc.select("span[itemprop=addressRegion]");
			for (Element urlUF : urlSearch) {
				return urlUF.text();
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		}
		return CEP;
	}

	public String getLatLong() throws IOException, ParseException {
		try {

			if (CEP.contains("-")) {
				Document doc = Jsoup.connect("http://maps.googleapis.com/maps/api/geocode/xml?address=" + CEP
						+ "&language=pt-BR&sensor=true").timeout(120000).get();
				Elements lat = doc.select("geometry").select("location").select("lat");
				Elements lng = doc.select("geometry").select("location").select("lng");
				for (Element Latitude : lat) {
					for (Element Longitude : lng) {
						return Latitude.text() + "," + Longitude.text();
					}

				}
			} else {

				StringBuilder cepHif = new StringBuilder(CEP);
				cepHif.insert(CEP.length() - 3, '-');

				Document doc = Jsoup.connect("http://maps.googleapis.com/maps/api/geocode/xml?address=" + cepHif
						+ "&language=pt-BR&sensor=true").timeout(120000).get();
				Elements lat = doc.select("geometry").select("location").select("lat");
				Elements lng = doc.select("geometry").select("location").select("lng");
				for (Element Latitude : lat) {
					for (Element Longitude : lng) {
						return Latitude.text() + "," + Longitude.text();
					}

				}
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		}
		return CEP;
	}
}
