package com.project.exportpdf.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import com.project.exportpdf.model.PDF;
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

/**
 * @author gamota
 *
 */

public class Export {

	public void exportPDF(PDF infos) {
		Document document = new Document();
		try {

			PdfWriter.getInstance(document,
					new FileOutputStream("src/lostPets/PDFs/" + infos.getAnimalID() + infos.getAnimalName() + ".pdf"));
			document.open();

			Paragraph pTitulo = (new Paragraph(
					new Phrase(50F, "PROCURA-SE", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 48F))));
			pTitulo.setAlignment(Element.ALIGN_CENTER);
			document.add(pTitulo);

			Paragraph pData = (new Paragraph("Perdido no dia: " + infos.getLostDate(),
					FontFactory.getFont(FontFactory.HELVETICA, 10)));
			pData.setAlignment(Element.ALIGN_CENTER);
			pData.setSpacingBefore(5);
			document.add(pData);

			BarcodeQRCode barcodeQRCode = new BarcodeQRCode(infos.getAnimalSitePath(), 1000, 1000, null);
			Image codeQrImage = barcodeQRCode.getImage();
			codeQrImage.setAbsolutePosition(490, 0);
			codeQrImage.scaleAbsolute(100, 100);
			document.add(codeQrImage);

			Image imgAnimal = Image.getInstance(infos.getAnimalImgPath());
			imgAnimal.setAbsolutePosition(120, 480);
			imgAnimal.scaleAbsolute(350, 240);
			imgAnimal.setBorder(Rectangle.BOX);
			imgAnimal.setBorderColor(BaseColor.BLACK);
			imgAnimal.setBorderWidth(2f);
			document.add(imgAnimal);

			Paragraph pTitlePhone = (new Paragraph("Informações: ",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20)));
			pTitlePhone.setAlignment(Element.ALIGN_CENTER);
			pTitlePhone.setSpacingBefore(260);
			document.add(pTitlePhone);

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}
}
