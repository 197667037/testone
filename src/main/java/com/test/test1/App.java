package com.test.test1;

import com.test.webservcie.HelloService;
import com.test.webservcie.HelloServiceService;

import java.util.Date;

/**
 * 通过wsimport生成客户端代码调用webservice服务
 */
public class App {
    public static void main(String[] args) {
        System.out.println(new Date());
        /**
         * wsdl:<service name="HelloServiceService">
         */
        HelloServiceService hss = new HelloServiceService();
        /**
         * wsdl:<port name="HelloServicePort" binding="tns:HelloServicePortBinding">
         */
        HelloService soap = hss.getHelloServicePort();
        String str = soap.sayHello("intsmaze");//这里我们看视乎在调用我们本地的方法，其实内部把发送数据组装为soap协议，
//        然后把数据发送到了服务端，服务端的线程接收到请求处理返回了数据。
        System.out.println(str);
    }
}