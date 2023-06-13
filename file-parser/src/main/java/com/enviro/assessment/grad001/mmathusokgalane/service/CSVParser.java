package com.enviro.assessment.grad001.mmathusokgalane.service;

import com.enviro.assessment.grad001.mmathusokgalane.Interface.FileParser;
import com.enviro.assessment.grad001.mmathusokgalane.repository.AccountProfile;
import org.apache.catalina.Session;
import org.apache.catalina.Store;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

public class CSVParser implements FileParser {

    @Override
    public void parseCSV(File csvFile) {
        String fileName = "./resources/1672815113084-GraduateDev_AssessmentCsv_Ref003.csv";
        try {
            // Read the file contents
            String fileContent = new String(Files.readAllBytes(csvFile.toPath()));

            // Split the file content into lines
            String[] lines = fileContent.split("\n");

            for (String line : lines) {
                // Split each line by comma
                String[] fields = line.split(",");

                // Extract the fields from the line
                String name = fields[0].trim();
                String surname = fields[1].trim();
                String base64Image = fields[2].trim();
                String notes = fields[3].trim();

                // Convert base64 image data to physical file
                File imageFile = convertCSVDataToImage(base64Image);

                // Create AccountProfile object and store in the database
                AccountProfile accountProfile = new AccountProfile(name, surname, imageFile.getName(), notes);
                storeAccountProfile(accountProfile);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error parsing file", e);
        }
    }

    private void storeAccountProfile(AccountProfile accountProfile) {
        try {
            // Save the accountProfile into the database using the repository
            Store accountProfileRepository = null;
            accountProfileRepository.save((Session) accountProfile);
        } catch (Exception e) {
            throw new RuntimeException("Error storing AccountProfile", e);
        }
    }


    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        try {
            byte[] imageData = Base64.getDecoder().decode(base64ImageData);
            File imageFile = File.createTempFile("image", ".jpg");
            FileOutputStream fos = new FileOutputStream(imageFile);
            fos.write(imageData);
            fos.close();
            return imageFile;
        } catch (IOException e) {
            throw new RuntimeException("Error converting CSV image data to file", e);
        }
    }

    @Override
    public URI createImageLink(File fileImage) {
        try {
            String fileName = fileImage.getName();
            Path filePath = Paths.get("./images/" + fileName);

            // Move the image file to the desired location
            Files.move(fileImage.toPath(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Generate the link to access the image file via a REST endpoint
            String imageLink = "/images/" + fileName;

            return new URI(imageLink);
        } catch (Exception e) {
            throw new RuntimeException("Error creating image link", e);
        }
    }
}
