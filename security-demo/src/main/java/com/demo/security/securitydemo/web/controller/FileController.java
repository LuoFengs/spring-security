package com.demo.security.securitydemo.web.controller;

import com.demo.security.securitydemo.dto.FileInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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



}
