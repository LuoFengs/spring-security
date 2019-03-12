package com.demo.security.dto;

/**
 * @author : luofeng
 * @date : Created in 2019/2/28 17:01
 * @description :
 */
public class FileInfo {

    String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
