package utils;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PdfUtils {

    //Using iTextPDF reader
    public static void readPdfUsingReader(String filePath) throws IOException {

        String output="";
        PdfReader reader=new PdfReader(filePath);
        int pages=reader.getNumberOfPages();

        StringBuilder text=new StringBuilder();
        for(int i=1; i<= pages; i++){
            text.append(PdfTextExtractor.getTextFromPage(reader, i));
        }
        reader.close();
    }

    //Read PDf with Loader
    public static String readPDFusingLoader(String filePath) throws FileNotFoundException {
        String text = "";

        if(filePath == null || filePath.isEmpty()){
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        try (PDDocument document = Loader.loadPDF(new File(filePath))) {

            if (!document.isEncrypted()) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                text = pdfStripper.getText(document);
            } else {
                throw new RuntimeException("PDF is encrypted and can not be read");
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading PDF file", e);
        }

        return text;
    }
}
