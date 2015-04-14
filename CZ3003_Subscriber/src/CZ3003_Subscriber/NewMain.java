/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CZ3003_Subscriber;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;

/**
 *
 * @author Bryden
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, COSVisitorException {

        String imagePath = "C:\\Users\\Bryden\\Desktop\\pie-sample.png";

        try (// Create a document and add a page to it
                PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);
            document.addPage(page);
            
// Create a new font object selecting one of the PDF base fonts
            PDFont font = PDType1Font.HELVETICA_BOLD;
            
            InputStream in = Files.newInputStream(Paths.get(imagePath));
            PDJpeg img = new PDJpeg(document, in);
            
// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
            try (// Start a new content stream which will "hold" the to be created content
                    PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
                contentStream.beginText();
                contentStream.setFont(font, 12);
                contentStream.moveTextPositionByAmount(100, 700);
                contentStream.drawString("Hello World");
                contentStream.endText();
                
                contentStream.drawImage(img, 10, 10);
                
// Make sure that the content stream is closed:
            }
            
            img.clear();
            
// Save the results and ensure that the document is properly closed:
            document.save("Hello World.pdf");
        }
    }

}
