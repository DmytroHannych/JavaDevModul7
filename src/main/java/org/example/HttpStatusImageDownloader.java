package org.example;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpStatusImageDownloader {
    private static final String FOLDER = "dowlands_files";
    private HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
    private OkHttpClient client = new OkHttpClient();
    private Request.Builder requestBiulder = new Request.Builder();
    private String fileName;

    public void downloadStatusImage(int code) throws URISyntaxException, IOException, InterruptedException {
        Request request = requestBiulder.get()
                .url(httpStatusChecker.getStatusImage(code))
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        String fileName = code + ".jpeg";
        InputStream inputStream = response.body().byteStream();
        Path path = getPath();
        Files.createDirectories(path);
        File file = new File(path + File.separator + fileName);
        FileOutputStream fis = new FileOutputStream(file);
        fis.write(inputStream.readAllBytes());
        fis.flush();
        fis.close();
    }

    public  Path getPath(){
        return Path.of("user.dir" + File.separator + FOLDER);
    }
}
