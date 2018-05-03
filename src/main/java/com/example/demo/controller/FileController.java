package com.example.demo.controller;

import com.example.demo.utils.FTPUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by OL-PC on 2018/04/23.
 */
@Controller()
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/open")
    public String open(){
        return "upload";
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("fileName") MultipartFile file, HttpServletRequest request){
        String fileName = file.getOriginalFilename();
        //String pathName = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"temp/";

        try{
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            File pathName = new File(path.getAbsolutePath(),"temp");
            File dest = new File(pathName,fileName);
            if(!dest.exists()){
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "fail";
    }
    @RequestMapping(value = "/uploadFtp",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFtp(@RequestParam("fileName") MultipartFile file) throws Exception{
        String filename = file.getOriginalFilename();
        InputStream is = file.getInputStream();
        System.out.println(filename);
        String pathname = "test";

        FTPClient ftp = new FTPClient();
        ftp.connect("10.88.125.196");
        ftp.login("OL-PC","aa950919/");
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.setControlEncoding("UTF-8");
        ftp.makeDirectory(pathname);
        ftp.changeWorkingDirectory(pathname);


        OutputStream os = ftp.storeFileStream(new String(filename.getBytes("GBK"),"iso-8859-1"));
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = is.read(buffer)) != -1){
            os.write(buffer,0,length);
        }
        os.flush();
//        is.close();
        os.close();
        return "success";
    }
}
