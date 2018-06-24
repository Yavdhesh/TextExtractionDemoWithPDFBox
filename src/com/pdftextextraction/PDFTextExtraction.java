package com.pdftextextraction;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;




public class PDFTextExtraction {
	
	public static void main(String args[]){
		 PDFTextStripper pdfStripper = null;
	        PDDocument pdDoc = null;
	        COSDocument cosDoc = null;
	        File file = new File("C:\\Users\\hp\\Desktop\\portrait_practice\\air.pdf");
	        try {
	            // PDFBox 2.0.8 require org.apache.pdfbox.io.RandomAccessRead 
	             RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r"); //apache
	             PDFParser parser = new PDFParser(randomAccessFile);

	           // PDFParser parser = new PDFParser(new FileInputStream(file));
	            parser.parse();
	            cosDoc = parser.getDocument();
	            pdfStripper = new PDFTextStripper();
	            pdDoc = new PDDocument(cosDoc);
	            pdfStripper.setStartPage(1);
	            pdfStripper.setEndPage(5);
	            String parsedText = pdfStripper.getText(pdDoc);
	            System.out.println(parsedText);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 	}

}
