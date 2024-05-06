package com.bemal.prescription_app.Helper;

import com.bemal.prescription_app.Dto.SinglePrescriptionRequest;
import com.bemal.prescription_app.Entity.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneratePdf {

    public static void generatePrescriptionHtml(TemplateEngine templateEngine, SinglePrescriptionRequest prescription,
                                                User user, String filePath){
        String fileName = "prescription.html";
        String path = "D:\\prescription_app\\backend\\prescription_app\\generated\\html\\";

        Context context = new Context();
        context.setVariable("prescription", prescription);
        context.setVariable("user", user);

        String htmlContent = templateEngine.process("prescriptionTemplate", context);

        try {
            File file = new File(path, fileName);
            if (file.createNewFile()) {
                FileWriter myWriter = new FileWriter(path + fileName);
                myWriter.write(htmlContent);
                myWriter.close();

                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }

    public static void generatePdfFromHtml(String htmlFilePath, String pdfFilePath) {
        try {
            Path htmlPath = Paths.get(htmlFilePath);
            String htmlContent = new String(Files.readAllBytes(htmlPath));

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();

            try (FileOutputStream outputStream = new FileOutputStream(pdfFilePath)) {
                renderer.createPDF(outputStream);
            }

            File fileToDelete = new File(htmlFilePath);

            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }

            System.out.println("PDF generated successfully at: " + pdfFilePath);
        } catch (IOException e) {
            System.out.println("Error occurred while reading HTML file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
