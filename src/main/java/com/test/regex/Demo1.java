package com.test.regex;

import com.sun.media.sound.SoftTuning;
import org.apache.xerces.dom.PSVIAttrNSImpl;
import org.apache.xpath.SourceTree;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: liuxl
 * @date: 2018-11-23 09:59
 * @description:
 */
public class Demo1 {


    @Test
    public void test0(){
        String s = "\t\t\tproperty_share ps ";
        Pattern p = Pattern.compile("\tproperty_share ");
        Matcher matcher = p.matcher(s);
        String s1 = matcher.replaceAll("\tbase.property_share ");
        System.out.println(s1);

    }
    @Test
    public void test1() throws IOException {

//        String pathname = "D:\\Administrator\\Desktop\\EmsAppListMapper.xml";
        String pathname = "D:\\Administrator\\Desktop\\property-share.xml";
        String baseTable = "D:\\Administrator\\Desktop\\base_table-3.txt";

        File file = new File(baseTable);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        List<String> baseTableList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            baseTableList.add(line);
        }

        file = new File(pathname);
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        String data = sb.toString();
        boolean modify = false;
        for (String s : baseTableList) {
            Pattern p = Pattern.compile("\t"+s+" ");
            Matcher matcher = p.matcher(data);
            if (matcher.find()) {
                modify = true;
            }
            data = matcher.replaceAll("\tbase." + s + " ");
        }
        FileWriter fw = null;
        if (modify) {
            fw = new FileWriter(file);
            fw.append(data);
            fw.close();
        }
        br.close();
        fr.close();

    }

    public static void main(String[] args) {

        test11("d:\\workspace\\fld\\fld-parent");
//        test111("D:\\workspace\\test_two\\src\\main\\java\\com\\test\\mapper\\mapper");
//        test11("D:\\workspace\\fld\\fld-parent\\fld-service\\fld-business-ord\\src\\main\\resources\\mapper");
    }

    public static void test11(String filePath) {
        File file = new File(filePath);

        if (file.isDirectory()) {
            for (File f1 : file.listFiles()) {
                if (f1.isFile() && f1.getName().endsWith(".xml")) {

                    try {
                        replace(f1.getPath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (f1.isDirectory()) {
                    test11(f1.getPath());
                }
            }
        } else if (file.isFile() && file.getName().endsWith(".xml")) {
            System.out.println("------------------" + file);
        }
    }

    static List<String> baseTableList = new ArrayList<>();



    public static void getTableName(String baseTablePath) throws Exception {
        if (baseTableList.size() == 0) {
            File file = new File(baseTablePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                baseTableList.add(line);
            }
            br.close();
            fr.close();
        }
    }
    public static void test111(String filePath) {
        File file = new File(filePath);

        if (file.isDirectory()) {
            for (File f1 : file.listFiles()) {
                if (f1.isFile() && f1.getName().endsWith(".xml")) {

                    try {
                        replace1(f1.getPath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (f1.isDirectory()) {
                    System.out.println("1111111111111111111");
//                    test11(f1.getPath());
                }
            }
        } else if (file.isFile() && file.getName().endsWith(".xml")) {
            System.out.println("------------------" + file);
        }
    }

    public static void replace1(String filePath) throws Exception {
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader  br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        String data = sb.toString();
        boolean modify = false;
//            Pattern p = Pattern.compile("\t"+s+" ");
//            Pattern p = Pattern.compile("<update id=\"");
            Pattern p = Pattern.compile("<up1date id=\"");
//            Pattern p = Pattern.compile(" "+s+" ");
            Matcher matcher = p.matcher(data);
            if (matcher.find()) {
                modify = true;
            }
//            data = matcher.replaceAll(" base." + s + " ");
//            data = matcher.replaceAll("<up1date id=\"");
            data = matcher.replaceAll("<update id=\"");
        FileWriter fw = null;
        if (modify) {
            System.out.println(file.getPath());
            System.out.println("----------modify----------");
            fw = new FileWriter(file);
            fw.append(data);
            fw.close();
        }
        br.close();
        fr.close();
    }
    public static void replace(String filePath) throws Exception {
//        String pathname = "D:\\Administrator\\Desktop\\EmsAppListMapper.xml";
        String pathname = filePath;
//        String baseTablePath = "D:\\Administrator\\Desktop\\base_table-3.txt";
        String baseTablePath = "D:\\Administrator\\Desktop\\4batch.txt";
        getTableName(baseTablePath);
        File file = new File(pathname);
        FileReader fr = new FileReader(file);
        BufferedReader  br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        String data = sb.toString();
        boolean modify = false;
        for (String s : baseTableList) {
//            Pattern p = Pattern.compile("\t"+s+" ");
//            Pattern p = Pattern.compile(" "+s+"\\n");
            Pattern p = Pattern.compile(" "+s+" ");
            Matcher matcher = p.matcher(data);
            if (matcher.find()) {
                modify = true;
            }
            data = matcher.replaceAll(" base." + s + " ");
//            data = matcher.replaceAll("\tbase." + s + " ");
//            data = matcher.replaceAll("base." + s);
        }
        FileWriter fw = null;
        if (modify) {
            System.out.println(file.getPath());
            System.out.println("----------modify----------");
            fw = new FileWriter(file);
            fw.append(data);
            fw.close();
        }
        br.close();
        fr.close();
    }


    @Test
    public void test3(){
        String data = "  <update id=\"updateByPrimaryKey\" parameterType=\"com.test.mapper.model.back.TitleInfo\">\n" +
                "    update title_info\n" +
                "    set TITLE_TYPE = #{titleType,jdbcType=DECIMAL},\n" +
                "      TITLE = #{title,jdbcType=VARCHAR},\n" +
                "      PHONE = #{phone,jdbcType=VARCHAR},\n" +
                "      TAX_NO = #{taxNo,jdbcType=VARCHAR},";
        Pattern p = Pattern.compile(" title_info"+"\\n");
//      Pattern p = Pattern.compile(" title_info ");
        Matcher matcher = p.matcher(data);
        if (matcher.find()) {
            System.out.println(1);
        }
            data = matcher.replaceAll(" base.title_inf\\n");
        System.out.println(data);

    }

    @Test
    public void test2() {
//        Pattern p = Pattern.compile("a");
//        Matcher matcher = p.matcher("abc defg");
//        System.out.println(matcher.matches());

//        String line = "This order was placed for QT3000! OK?";
        String line = "<!DOCTYPE mapper PUBLIC \"-//ibatis.apache.org//DTD Mapper 3.0//EN\"\n" +
                "\"http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd\">\n" +
                "<mapper namespace=\"com.feiliks.hn.wms.mapper.WmsMapper\">";
//        String pattern = "placed1";
        String pattern = "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);


        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        m.replaceAll("http://mybatis.org/dtd/mybatis-3-mapper.dtd");
        System.out.println(m.matches());
        System.out.println(m.find());

//        int end = matcher.end();
//        System.out.println(end);
    }

}