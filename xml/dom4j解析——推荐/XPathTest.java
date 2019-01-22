package cn.itcast.dom4j;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XPathTest {
	
	public static void main(String[] args) throws Exception {
		
		//获得document
		//获得解析流
		SAXReader reader = new SAXReader();
		//解析xml
		Document document  = reader.read("books.xml");
		
		//查询book id = b002 的元素   java.lang.NoClassDefFoundError
		Node node = document.selectSingleNode("//book[@id='b002']"); 
		
		System.out.println(node);
		
	}

}
