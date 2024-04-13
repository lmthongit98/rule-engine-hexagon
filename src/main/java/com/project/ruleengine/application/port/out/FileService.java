package com.project.ruleengine.application.port.out;

import java.io.InputStream;

public interface FileService {
    String uploadFile(InputStream fileStream, String fileName);
    byte[] downloadFile(String fileName);
}