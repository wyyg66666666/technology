package cn.itcast.jaxp.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class SaxTest {
	
	public static void main(String[] args) throws Exception {
		
		//获得解析工厂实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//获得解析器
		SAXParser parser = factory.newSAXParser();
		
		DefaultHandler dh = new MyDefaultHandler();
		
		
		//解析xml文档
		parser.parse("books.xml", dh);
		
		
		System.out.println("done");
		
	}

}
