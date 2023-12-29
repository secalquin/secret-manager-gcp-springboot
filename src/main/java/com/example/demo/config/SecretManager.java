package com.example.demo.config;

import com.google.cloud.secretmanager.v1.*;

import java.io.IOException;

public class SecretManager {

    public static String getSecret(String projectId, String secretId, String versionId)  throws IOException {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretId, versionId);

            AccessSecretVersionResponse response = client.accessSecretVersion(secretVersionName);

            String payload = response.getPayload().getData().toStringUtf8();
            return payload;
        }
    }
}
