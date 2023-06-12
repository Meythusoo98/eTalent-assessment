package com.enviro.assessment.grad001.mmathusokgalane.Interface;
import java.io.File;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvFile);
    File convertCSVDataToImage(String base64ImageData);
    URI createImageLink(File fileImage);
}
