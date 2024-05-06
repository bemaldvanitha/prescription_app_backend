package com.bemal.prescription_app.Helper;

import com.bemal.prescription_app.Dto.SinglePrescriptionRequest;
import com.bemal.prescription_app.Entity.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}
