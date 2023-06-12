package com.enviro.assessment.grad001.mmathusokgalane.controller;
import com.enviro.assessment.grad001.mmathusokgalane.repository.AccountProfile;
import com.enviro.assessment.grad001.mmathusokgalane.repository.AccountProfileRepository;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    private final AccountProfileRepository accountProfileRepository;

    public ImageController(AccountProfileRepository accountProfileRepository) {
        this.accountProfileRepository = accountProfileRepository;
    }
    @GetMapping(value = "/{name}/{surname}/{\\w\\.\\w}")
    public ResponseEntity<Resource> getHttpImageLink(@PathVariable String name, @PathVariable String surname, @PathVariable String fileName){
        AccountProfile accountProfile = accountProfileRepository.findByNameAndSurname(name, surname);

        if (accountProfile == null) {
            return ResponseEntity.notFound().build();
        }

        String imageFileName = accountProfile.getHttpImageLink();
        if (!imageFileName.equals(fileName)) {
            return ResponseEntity.notFound().build();
        }

        Path imagePath = Paths.get("./images/" + fileName);
        Resource imageResource = new FileSystemResource(imagePath.toFile());

        if (imageResource.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
