package com.chattech.coherence.utils;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 12/11/2012
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
public class IOUtils {

    public static void writeToFile(InputStream inputStream, File outputFile) {
        try {
            OutputStream fos = new FileOutputStream(outputFile);
            OutputStream bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int lenth = 0;
            while((lenth = inputStream.read(buffer)) != -1){
                bos.write(buffer, 0, lenth);
            }
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readFromFile(File inputFile){
        byte[] read = null;
        try{
            InputStream fis = new FileInputStream(inputFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while((length = fis.read(buffer)) != -1){
                baos.write(buffer, 0, length);
            }
            read = baos.toByteArray();
        } catch(IOException e){
            e.printStackTrace();
        }
        return read;
    }
}
