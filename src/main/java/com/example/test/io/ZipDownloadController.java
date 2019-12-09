package com.example.test.io;

import org.springframework.http.*;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class ZipDownloadController {

    @GetMapping(name = "/exportZip",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void exportZip(HttpServletResponse response) throws IOException {
        String sessionId = "3e50ee2d-6e37-4383-844c-10458b133f64";
        String fileId = "296316962327986176";
        String fileName = "doc1.zip";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));

        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("sessionId", sessionId);
        uriVariables.put("resourceId", fileId);

        String url = "http://file.dev.rs.com:80/file/private/download/{sessionId}/{resourceId}";

        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, byte[].class, uriVariables);
        byte[] fileBytes = responseEntity.getBody();

        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        response.setHeader("Connection","close");
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes("GB2312"), "ISO8859-1"));
        response.setCharacterEncoding("UTF-8");


        ZipEntry zipEntry = new ZipEntry("pic1.png");
        zos.putNextEntry(zipEntry);
        zos.write(fileBytes,0,fileBytes.length);
        zos.closeEntry();

        zos.flush();
        zos.close();
    }
}
