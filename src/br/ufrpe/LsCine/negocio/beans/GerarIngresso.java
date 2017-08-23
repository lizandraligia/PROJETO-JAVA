package br.ufrpe.LsCine.negocio.beans;
import br.ufrpe.LsCine.imagens.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class GerarIngresso {
	
	public static void geradorPDF(Ingresso ingresso){
		
		Document documento = new Document();
		
		try{
			PdfWriter.getInstance(documento, new FileOutputStream("encomenda.pdf"));
			
			documento.open();
			Image img = Image.getInstance("/br/ufrpe/LsCine/imagens/Logo.png");
			documento.add(img);
			documento.add(new Paragraph ("\n\n\n"));
			documento.add(new Paragraph("Informações da Encomenda " + ingresso.getId() + "\n\n\n\n"));
			documento.add(new Paragraph(ingresso.toString()+ "\n\n"));
			
		}catch(DocumentException e){
			System.out.println(e.getMessage());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			documento.close();
		}
		
		try{
			Desktop.getDesktop().open(new File("encomenda.pdf"));
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}

}
