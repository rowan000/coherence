package com.chattech.coherence.utils;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 12/11/2012
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
public class IOUtilsTest {

    private final String contents = "contents";
    @Test
    public void canWriteToFile(){

        File outputFile = writeFile();
        System.out.println("File path: " + outputFile.getAbsolutePath());
        assertEquals(true, outputFile.exists());
        outputFile.delete();
        assertEquals(false, outputFile.exists());
    }

    @Test
    public void canReadFromFile(){
        File outputFile = writeFile();

        byte[] contentsFromFile = IOUtils.readFromFile(outputFile);

        assertEquals(contents, new String(contentsFromFile));
        outputFile.delete();
        assertEquals(false, outputFile.exists());
    }

    private File writeFile(){
        InputStream bais = new ByteArrayInputStream(contents.getBytes());
        File outputFile = new File("temp.txt");
        IOUtils.writeToFile(bais, outputFile);
        return outputFile;
    }
}
