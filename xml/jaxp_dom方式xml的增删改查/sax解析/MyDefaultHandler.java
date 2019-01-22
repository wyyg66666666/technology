package cn.itcast.jaxp.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("文档开始");
	}

	@Override
	/**
	 * 如果xml文件使用了schema约束 <xs:element>
	 * 	 * uri:schema -- targetNameSpace   
	 *   * localName--element
	 *   * qName---xs:element
	 * 如果不使用
	 *   * uri:null
	 *   * localName:null
	 *   * qName : element
	 *   
	 * Attributes:当前元素的所有的属性的集合
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("元素开始" + qName + " *** " + attributes.getValue("id"));
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println(new String(ch ,start, length));
		
	}


	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("元素结束：" + qName);
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("文档结束");
	}
	

}
