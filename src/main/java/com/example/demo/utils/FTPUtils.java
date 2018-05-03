package com.example.demo.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OL-PC on 2018/04/24.
 */
@Component
@PropertySource({"classpath:/ftpconfig.properties"})
public class FTPUtils {
    private static FTPClient ftpClient;

    private static List<String> filenames = new ArrayList<>();
    private static String ip;

    private static int port;

    private static String username;

    private static String password;

    public String getIp() {
        return ip;
    }
    @Value("#{prop['ip']}")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }
    @Value("#{prop['port']}")
    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }
    @Value("#{prop['username']}")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    @Value("#{prop['password']}")
    public void setPassword(String password) {
        this.password = password;
    }

    static {
        ftpClient = new FTPClient();
    }

    public static void connect(){
        try {
            ftpClient.connect("10.88.125.196",21);
            System.out.println("connect success");
        } catch (IOException e) {
            throw new RuntimeException("connect failed",e);
        }
    }

    public static void login(){
        try {
            ftpClient.login("","");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.setCharset(Charset.forName("UTF-8"));
            ftpClient.setControlEncoding("UTF-8");
            System.out.println("login success");
        } catch (IOException e) {
            throw new RuntimeException("login failed",e);
        }
    }
    public static List<String> listFiles(String pathname){
        FTPFile[] ftpFiles = null;
        try {
            if (pathname != null && !pathname.equals("")){
                ftpFiles = ftpClient.listFiles(pathname);
            }
            ftpFiles = ftpClient.listFiles();
            for (FTPFile ftpFile : ftpFiles){
                filenames.add(ftpFile.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filenames;
    }
    public static boolean uploadFile(String path, String filename, InputStream file){
        boolean success = false;
        try {
            connect();
            login();
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)){
                ftpClient.disconnect();
                return success;
            }
            ftpClient.changeWorkingDirectory(path);
            ftpClient.storeFile(filename,file);
            success = true;
            file.close();
            ftpClient.logout();
            System.out.println("上传成功！");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }
}
