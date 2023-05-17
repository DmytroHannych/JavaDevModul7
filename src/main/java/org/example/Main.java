package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
//        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
//        String statusImage = httpStatusChecker.getStatusImage(200);
//        System.out.println("statusImage = " + statusImage);
//        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
//        httpStatusImageDownloader.downloadStatusImage(200);
       HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
       httpImageStatusCli.askStatus();
    }
}