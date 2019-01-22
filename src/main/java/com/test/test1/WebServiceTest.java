package com.test.test1;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author: liuxl
 * @date: 2018-04-23 11:46
 * @description:
 */
@WebService
public class WebServiceTest {

    public String transString(String words){
        String res = "";
        for (char c : words.toCharArray()) {
            res += c + ",";
        }
        return res;

    }

    public static void main(String[] args) {
        // 使用Endpoint(终端)类发布webservice
        Endpoint.publish("http://localhost:8089/service/function", new WebServiceTest());
        System.out.println("Publish Success");
       }

}
