package Publisher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Bryden
 */
public class CReport {

    public static String genReport(JSONArray pObjAry) throws IOException, COSVisitorException {

        List<List<String>> lstContents = new ArrayList<>();

        List<String> aryLst = new ArrayList<>();

        aryLst.add("Incident Type");
        aryLst.add("Percentage");

        lstContents.add(aryLst);

        for (Object obj : pObjAry) {
            JSONObject objJson = (JSONObject) obj;

            Iterator<?> keys = objJson.keySet().iterator();

            while (keys.hasNext()) {
                String key = (String) keys.next();
                // loop to get the dynamic key
                String value = objJson.get(key) + "%";

                List<String> aryValues = new ArrayList<>();

                aryValues.add(key);
                aryValues.add(value);

                lstContents.add(aryValues);
            }

        }

        try (// Create a document and add a page to it
                PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);
            document.addPage(page);

// Create a new font object selecting one of the PDF base fonts
            PDFont font = PDType1Font.HELVETICA_BOLD;

// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
            try (// Start a new content stream which will "hold" the to be created content
                    PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
                contentStream.beginText();
                contentStream.setFont(font, 20);
                contentStream.moveTextPositionByAmount(70, 720);
                contentStream.drawString("Incident Summary " + new Date());
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(font, 20);
                contentStream.moveTextPositionByAmount(100, 670);
                contentStream.drawString("Statistics");
                contentStream.endText();

                drawTable(page, contentStream, 650, 100, lstContents);

// Make sure that the content stream is closed:
            }

// Save the results and ensure that the document is properly closed:
            document.save("Report.pdf");

            return Paths.get("Report.pdf").toAbsolutePath().toString();

        }

    }

    public static void drawTable(PDPage page, PDPageContentStream contentStream,
                                 float y, float margin,
                                 List<List<String>> content) throws IOException {

        final int rows = content.size();
        final int cols = content.get(0).size();

        final float rowHeight = 20f;
        final float tableWidth = page.findMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth / (float) cols;
        final float cellMargin = 5f;

        //draw the rows
        float nexty = y;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        //draw the columns
        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
            nextx += colWidth;
        }

        //now add the text
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

        float textx = margin + cellMargin;
        float texty = y - 15;
        for (List<String> content1 : content) {
            for (String text : content1) {
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }

    }

}
