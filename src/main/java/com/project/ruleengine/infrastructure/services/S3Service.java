package com.project.ruleengine.infrastructure.services;

import com.project.ruleengine.application.port.out.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class S3Service implements FileService {

//    private final AmazonS3 s3Client;
//    private final String bucketName;

    @Override
    public String uploadFile(InputStream fileStream, String fileName) {
//        ObjectMetadata metadata = new ObjectMetadata();
//        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileStream, metadata));
//        return s3Client.getUrl(bucketName, fileName).toString();
        return "";
    }

    @Override
    public byte[] downloadFile(String fileName) {
        // Method to download file from S3
        return new byte[0];
    }
}
