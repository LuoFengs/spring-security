package com.demo.security.securitydemo.web.controller;

import com.demo.security.securitydemo.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author : luofeng
 * @date : Created in 2019/2/28 16:59
 * @description :
 */
@RestController
@RequestMapping("/file")
public class FileController {



    @PostMapping
    public FileInfo upload(HttpServletRequest request, MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        String url = request.getSession().getServletContext().getRealPath("") + "/upload";
        Path path = Paths.get(url);
        Path directory = Files.createDirectory(path);
        System.out.println(directory.toString());
        File localFile = new File(directory.toString(),file.getName()+(new Date().getTime())+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String url = request.getSession().getServletContext().getRealPath("") + "/upload";
        try (
                InputStream inputStream = new FileInputStream(new File(url,id+".txt" ));
                OutputStream outputStream = response.getOutputStream();
        ){
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition","attachment;filename=test.txt");

            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }


}
