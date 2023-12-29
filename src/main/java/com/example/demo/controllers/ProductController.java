package com.example.demo.controllers;

import com.example.demo.config.SecretManager;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ProductController {

    @Value("${ciam.gcp.projectId}")
    private String projectId;

    @Value("${ciam.gcp.pemSecretId}")
    private String pemSecretId;

    @GetMapping(
            path = "/getAllProducts"
    )
    public ResponseEntity<?> getAllProducts() throws IOException {
        String secretValue = SecretManager.getSecret(projectId,pemSecretId,"latest");
        System.out.println(secretValue);

        Product product = new Product();
        product.setName("Naranja");
        product.setPrice(0.2);


        return ResponseEntity.ok(product);
    }


}
