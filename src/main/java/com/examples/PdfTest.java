package com.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfTest {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("A Hello World PDF document."));
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Document document2 = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document2, new FileOutputStream("SetAttributeExample.pdf"));
            document2.open();
            document2.add(new Paragraph("Some content here"));

            //Set attributes here
            document2.addAuthor("Lokesh Gupta");
            document2.addCreationDate();
            document2.addCreator("HowToDoInJava.com");
            document2.addTitle("Set Attribute Example");
            document2.addSubject("An example to show how attributes can be added to pdf files.");

            document2.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
