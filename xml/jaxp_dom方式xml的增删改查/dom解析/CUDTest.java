package cn.itcast.jaxp.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CUDTest {
	
	
	public static void main(String[] args) throws Exception{
		
		//将内存中的document，另存到books.jasp.xml文件中
		
		Document document = CUDTest.getDocument();
		
		
		//将document的内容修改：添加、删除、修改
		
		//添加
		/* 添加的内容
		 * <book id="b002">
				<title>Thinking in Java</title>
			 	<price>22000</price>
			</book>
		 * 给谁添加：根元素 books
		 */
		
		//获得books根元素
		Element rootElement = document.getDocumentElement();
		
		//创建book元素
		Element  newBook = document.createElement("book");
		//设置id属性
		newBook.setAttribute("id", "b003");
		
		//创建title元素
		Element titleElement = document.createElement("title");
		//将title元素，添加到新book元素中
		newBook.appendChild(titleElement);
		//给title添加值
		titleElement.setTextContent("凤姐写真");
		
		//将book元素添加到books根元素中
		
		rootElement.appendChild(newBook);
		
		
		
		
		//保存
		saveXml(document);
	}
	
	
	
	
	private void delete() throws Exception{
//将内存中的document，另存到books.jasp.xml文件中
		
		Document document = CUDTest.getDocument();
		
		
		//将document的内容修改：添加、删除、修改
		
		//删除   <book id="b001">
		//获得所有的书籍
		NodeList bookList = document.getElementsByTagName("book");
		for(int n = 0 ; n < bookList.getLength() ; n ++){
			//获得每一本书
			Node bookNode = bookList.item(n);
			//获得id的值
			Element bookElement = (Element) bookNode;
			String id = bookElement.getAttribute("id");
			//判断book id == b001
			if("b001".equals(id)){
				//删除 bookElement  当前节点，调用父节点，进行操作
				//获得父节点
				Node parent = bookElement.getParentNode();
				//操作
				parent.removeChild(bookElement);
			}
			
		}
		
		
		
		
		
		
		//保存
		saveXml(document);
	}
	private void update() throws Exception{
		//将内存中的document，另存到books.jasp.xml文件中
		
		Document document = CUDTest.getDocument();
		
		
		//将document的内容修改：添加、删除、修改
		
		//修改   <book id="b001"><title>Java 核心技术</title>   --》 Java Core
		//获得所有的书籍
		NodeList bookList = document.getElementsByTagName("book");
		for(int n = 0 ; n < bookList.getLength() ; n ++){
			//获得每一本书
			Node bookNode = bookList.item(n);
			//获得id的值
			Element bookElement = (Element) bookNode;
			String id = bookElement.getAttribute("id");
			//判断book id == b001
			if("b001".equals(id)){
				//获得所有的title
				NodeList childList = bookElement.getElementsByTagName("title");
				//获得唯一一个title
				Node title = childList.item(0);
				//获得title
				System.out.println(title.getTextContent());
				//设置值
				title.setTextContent("Java Core");
			}
			
		}
		
		
		
		
		
		
		//保存
		saveXml(document);
	}

	private static void saveXml(Document document) throws Exception {
		//获得持久化对象实例工厂
		TransformerFactory factory = TransformerFactory.newInstance();
		
		//获得持久化对象
		Transformer transformer = factory.newTransformer();
		//将内存数据，保存到硬盘
		
		//源：document  将document封装到Source
		Source xmlSource = new DOMSource(document);
		//结果：books.jasp.xml  将“文件路径”封装到Result
		Result outputTarget = new StreamResult("books.jasp.xml");
		transformer.transform(xmlSource, outputTarget);
		
		System.out.println("done");
	}
	
	/**
	 * 获得document对象
	 * @return
	 */
	public static Document getDocument() throws Exception{
		//获得工厂实例
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获得解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//获得document
		Document document = builder.parse("books.xml");
		
		return document;
	}

}
