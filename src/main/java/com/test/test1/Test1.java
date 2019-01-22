package com.test.test1;/**
 * Created by liuxl on ${date} ${time}
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: liuXl
 * create:2018/3/26 9:46
 */
public class Test1 {

    /**
     *
     */
    @Test
    public void test1() throws IOException {
    }

    @Test
    public void test2() throws JsonProcessingException {
        for (int i = 0; i < 10; i++) {

            System.out.println(i);
            for (int j = 0; j < 5; j++) {
                    System.out.println(j);
                if (j == 3){
                    break;
                }
            }
        }
    }

    @Test
    public void test3() throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        int BUFFER_SIZE = 1024;
        byte[] data = new byte[BUFFER_SIZE];
        InputStream in = new FileInputStream(new File("d:\\Administrator\\Downloads\\报文样例 (1).xml"));
        int count = -1;
        while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
            outStream.write(data, 0, count);

        data = null;
        System.out.println(outStream.toString());
    }

    @Test
    public void test4() {

    }

    /**
     * @param number
     * @throws Exception
     * @Description get方式请求
     */
    public void get(String number) throws Exception {
        //HttpClient：在java代码中模拟Http请求

    }
}
