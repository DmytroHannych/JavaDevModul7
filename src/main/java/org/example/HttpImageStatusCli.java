package org.example;

import org.example.HttpStatusChecker;
import org.example.HttpStatusImageDownloader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class HttpImageStatusCli {
     HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
     HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
    public void askStatus() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Please Enter HTTP status code");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Integer statusCode = Integer.valueOf(line);
        if(httpStatusChecker.getStatusImage(statusCode).contains(line)){
            httpStatusImageDownloader.downloadStatusImage(statusCode);
            System.out.println("Image by status code " + line + ". Successful");
        } else {
            System.out.println("There is not image for HTTP status" + " " + line);
        }
    }
}
