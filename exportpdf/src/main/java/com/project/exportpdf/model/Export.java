package com.project.exportpdf.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class Export {

	@SuppressWarnings("deprecation")
	public String exportPDF(PDF infos) {
		Document document = new Document();
		try {

			PdfWriter.getInstance(document,
					new FileOutputStream("src/lostPets/PDFs/" + infos.getAnimalID() + infos.getAnimalName() + ".pdf"));
			document.open();

			SearchCEP cep = new SearchCEP(infos.getCepLost());

			infos.getLostDate().setDate(infos.getLostDate().getDate() + 1);
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String data = formato.format(infos.getLostDate());

			Paragraph pTitulo = (new Paragraph(
					new Phrase(50F, "PROCURA-SE", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 48F))));
			pTitulo.setAlignment(Element.ALIGN_CENTER);
			document.add(pTitulo);

			Paragraph pData = (new Paragraph("Perdido no dia: " + data,
					FontFactory.getFont(FontFactory.HELVETICA, 12)));
			pData.setAlignment(Element.ALIGN_CENTER);
			pData.setSpacingBefore(5);
			document.add(pData);

			BarcodeQRCode barcodeQRCode = new BarcodeQRCode(infos.getAnimalSitePath(), 1000, 1000, null);
			Image codeQrImage = barcodeQRCode.getImage();
			codeQrImage.setAbsolutePosition(490, 0);
			codeQrImage.scaleAbsolute(100, 100);
			document.add(codeQrImage);

			Image imgAnimal = Image.getInstance(infos.getAnimalImgPath());
			imgAnimal.setAbsolutePosition(120, 400);
			imgAnimal.scaleAbsolute(350, 310);
			imgAnimal.setBorder(Rectangle.BOX);
			imgAnimal.setBorderColor(BaseColor.BLACK);
			imgAnimal.setBorderWidth(2f);
			document.add(imgAnimal);

			Paragraph pTituloInfos = (new Paragraph("Informações: ",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20)));
			pTituloInfos.setAlignment(Element.ALIGN_CENTER);
			pTituloInfos.setSpacingBefore(340);
			document.add(pTituloInfos);

			Paragraph pInfos = (new Paragraph(
					"\n" + infos.getAnimalInfos() + "\n" + infos.getHowWasLost() + "\n\nVisto pela última vez: \n",
					FontFactory.getFont(FontFactory.HELVETICA, 15)));
			pInfos.setAlignment(Element.ALIGN_CENTER);
			document.add(pInfos);

			Paragraph pAdress = (new Paragraph(cep.getAdress() + ", " + cep.getDistrict() + ", " + cep.getUF(),
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15)));
			pAdress.setAlignment(Element.ALIGN_CENTER);
			document.add(pAdress);

			Paragraph pOwner = (new Paragraph("\nDono: " + infos.getOwnerName(),
					FontFactory.getFont(FontFactory.HELVETICA, 15)));
			pOwner.setAlignment(Element.ALIGN_CENTER);
			document.add(pOwner);

			Paragraph pCont = (new Paragraph("\nContatos: " + infos.getOwnerNumber() + "\n" + infos.getOwnerEmail(),
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15)));
			pCont.setAlignment(Element.ALIGN_CENTER);
			document.add(pCont);

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
		return "src/lostPets/PDFs/" + infos.getAnimalID() + infos.getAnimalName() + ".pdf";
	}
}
