package cn.itcast.jaxp.dom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.itcast.domain.Book;

public class DomTest {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(getAllBook());
		
	}
	
	/*
	 * 获得所有的书籍，将所有的书籍内容保存list
	 */
	public static List getAllBook() throws Exception{
		//创建list，用于保存所有的数据
		List allBookList = new ArrayList();
		
		/* 从xml文档中将需要的数据，查询出来，替换模拟数据 */
		//获得实例工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获得解析
		DocumentBuilder builder = factory.newDocumentBuilder();
		//获得document --解析xml文档   java.io.FileNotFoundException
		Document document = builder.parse("books.xml");  //指java项目的根路径下的文件
		//获得所有的书籍元素
		NodeList bookElements = document.getElementsByTagName("book");
		//遍历所有的书籍元素
		for(int i = 0 ; i < bookElements.getLength() ; i++){
			//获得每一本书籍元素
			Node node = bookElements.item(i);
//			node.getAttributes();  --获得所有的属性
			Element bookEle = (Element)node;
			//获得指定名称id，的属性值
			String id = bookEle.getAttribute("id");
			String title = "";
			String price = "";
			
			//将title和price查询
			//获得当前book元素的所有的子节点
			NodeList childList = bookEle.getChildNodes();
			System.out.println( id + ":" + childList.getLength());
			//遍历所有的孩子
			for(int c = 0 ; c < childList.getLength() ; c++){
				//获得所有的孩子
				Node childNode = childList.item(c);
				//Element child = (Element)childNode;  //java.lang.ClassCastException:
				//获得节点名称
				String childName = childNode.getNodeName();
				
				//判断是否title
				//if(childName.equals("title"))
				if("title".equals(childName)){
					//获得title内容
					title = childNode.getTextContent();
				}
				
				//判断是否是price
				if("price".equals(childName)){
					price = childNode.getTextContent();
				}
			}
			
			
			
			
			
			//创建JavaBean Book对象
			Book book = new Book();
			book.setId(id);
			book.setPrice(price);
			book.setTitle(title);
			
			//将保存所有数据的对象Book添加到list中
			allBookList.add(book);
		
		}
		
		
		return allBookList;
	}
	
	
	
	
	
	
	
	

	private static void builder() throws ParserConfigurationException {
		//获得工厂实例
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获得解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		System.out.println(builder);
	}

}
