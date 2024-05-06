package com.bemal.prescription_app.Helper;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

import java.io.FileInputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirebaseStorageUploader {
    public static void initializeFirebaseAdminSDK() {
        try {
            FileInputStream serviceAccount = new FileInputStream("D:\\prescription_app\\backend\\prescription_app\\src\\main\\resources\\storeapp-f3d3b-firebase-adminsdk-jir2m-e9e687bf2f.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket("storeapp-f3d3b.appspot.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String uploadFileToStorage(String localFilePath, String storagePath) {
        try {
            StorageClient storageClient = StorageClient.getInstance();
            Blob blob = storageClient.bucket().create(storagePath, new FileInputStream(localFilePath),"text/html");

            URL signedUrl = blob.signUrl(30, TimeUnit.DAYS);
            return signedUrl.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
