package com.tsurugeek.jax_ws.test.ws.client;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBusFactory;

import com.tsurugeek.jax_ws.test.ws.HelloService;

public class HelloServiceClient {
	public static void main(String[] args){
		
		//--------------------
		// jax-wsの動作検証
		//--------------------

		System.out.println("start");
		
		HelloService service = new HelloService();
		System.out.println(service.getHelloPort().sayHello("jun"));
		
		System.out.println("end");
		
		// コンソールログ
		
//		start
//		情報: Refreshing org.apache.cxf.bus.spring.BusApplicationContext@2a098129: display name [org.apache.cxf.bus.spring.BusApplicationContext@2a098129]; startup date [Tue Feb 01 09:17:48 JST 2022]; root of context hierarchy [火 2 01 09:17:48 JST 2022]
//		情報: Loaded configuration file cxf.xml. [火 2 01 09:17:48 JST 2022]
//		情報: Loading XML bean definitions from class path resource [META-INF/cxf/cxf.xml] [火 2 01 09:17:48 JST 2022]
//		情報: Loading XML bean definitions from class path resource [cxf.xml] [火 2 01 09:17:48 JST 2022]
//		情報: Bean factory for application context [org.apache.cxf.bus.spring.BusApplicationContext@2a098129]: org.springframework.beans.factory.support.DefaultListableBeanFactory@63e2203c [火 2 01 09:17:48 JST 2022]
//		情報: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@63e2203c: defining beans [cxf,org.apache.cxf.bus.spring.BusWiringBeanFactoryPostProcessor,org.apache.cxf.bus.spring.Jsr250BeanPostProcessor,org.apache.cxf.bus.spring.BusExtensionPostProcessor,cxf.config0]; root of factory hierarchy [火 2 01 09:17:48 JST 2022]
//		情報: Creating Service {http://ws.test.jax_ws.tsurugeek.com/}HelloService from WSDL: http://localhost:8080/jax-ws.test/hello.ws?wsdl [火 2 01 09:17:48 JST 2022]
//		情報: Outbound Message
//		---------------------------
//		ID: 1
//		Address: http://localhost:8080/jax-ws.test/hello.ws
//		Encoding: UTF-8
//		Http-Method: POST
//		Content-Type: text/xml
//		Headers: {Accept=[*/*], SOAPAction=[""]}
//		Payload: <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><ns2:sayHello xmlns:ns2="http://ws.test.jax_ws.tsurugeek.com/"><arg0>jun</arg0></ns2:sayHello></soap:Body></soap:Envelope>
//		-------------------------------------- [火 2 01 09:17:48 JST 2022]
//		情報: Inbound Message
//		----------------------------
//		ID: 1
//		Response-Code: 200
//		Encoding: UTF-8
//		Content-Type: text/xml;charset=utf-8
//		Headers: {content-type=[text/xml;charset=utf-8], Date=[Tue, 01 Feb 2022 00:17:48 GMT], Server=[Apache-Coyote/1.1], transfer-encoding=[chunked]}
//		Payload: <?xml version="1.0" ?><S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"><S:Body><ns2:sayHelloResponse xmlns:ns2="http://ws.test.jax_ws.tsurugeek.com/"><return>Hello jun</return></ns2:sayHelloResponse></S:Body></S:Envelope>
//		-------------------------------------- [火 2 01 09:17:48 JST 2022]
//		Hello jun
//		end
		
		
		//--------------------
		// springの動作検証
		//--------------------

		// 読み込みは問題なく出きるっぽい（java 6 + Spring 2.7でも問題なさそう）
		Bus bus = new SpringBusFactory().createBus("cxf.xml");
		
		// コンソールログ
//		情報: Refreshing org.apache.cxf.bus.spring.BusApplicationContext@d41f816: display name [org.apache.cxf.bus.spring.BusApplicationContext@d41f816]; startup date [Tue Feb 01 09:17:48 JST 2022]; root of context hierarchy [火 2 01 09:17:48 JST 2022]
//		情報: Loaded configuration file cxf.xml. [火 2 01 09:17:48 JST 2022]
//		情報: Loading XML bean definitions from class path resource [META-INF/cxf/cxf.xml] [火 2 01 09:17:48 JST 2022]
//		情報: Loading XML bean definitions from class path resource [cxf.xml] [火 2 01 09:17:48 JST 2022]
//		情報: Bean factory for application context [org.apache.cxf.bus.spring.BusApplicationContext@d41f816]: org.springframework.beans.factory.support.DefaultListableBeanFactory@1e097d59 [火 2 01 09:17:48 JST 2022]
//		情報: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@1e097d59: defining beans [cxf,org.apache.cxf.bus.spring.BusWiringBeanFactoryPostProcessor,org.apache.cxf.bus.spring.Jsr250BeanPostProcessor,org.apache.cxf.bus.spring.BusExtensionPostProcessor,cxf.config1]; root of factory hierarchy [火 2 01 09:17:48 JST 2022]

		
		//--------------------
		// org.springframework.core.JdkVersionについて
		//--------------------

		// 3.2.4～4.0.0の段階では存在しているクラス
		// https://docs.spring.io/spring-framework/docs/3.2.4.RELEASE_to_4.0.0.RELEASE/changes/org.springframework.core.JdkVersion.html
		// 5.0から削除されたらしい
		// https://stackoverflow.com/questions/49469087/java-lang-noclassdeffounderror-org-springframework-core-jdkversion
		
		System.out.println(org.springframework.core.JdkVersion.getJavaVersion());
		System.out.println(org.springframework.core.JdkVersion.getMajorJavaVersion());
		
		// コンソールログ
//		1.8.0_202
//		1
	}
}
