package cn.itcast.dom4j;

import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class CURDTest {
	
	public static void main(String[] args) throws Exception {
		
		//获得document
		//获得解析流
		SAXReader reader = new SAXReader();
		//解析xml
		Document document  = reader.read("books.xml");
		
		//获得根元素
		Element rootElement = document.getRootElement();
		
		//添加
		//创建book元素
		Element newBook = DocumentHelper.createElement("book");
		
		//创建book元素的id属性
		Attribute  idAttr = DocumentHelper.createAttribute(newBook, "id", "b004");
		//添加到book元素中
		newBook.add(idAttr);
		
		
		//创建title元素
		Element titleElement = DocumentHelper.createElement("title");
		//设置值
		titleElement.setText("凤姐玉照");
		
		//添加到newbook
		newBook.add(titleElement);
		
		
		
		//将新book元素添加到root元素
		rootElement.add(newBook);
		
		
		//将document保存
		//持久化流
		
		//创建输出文件的位置
		FileOutputStream out = new FileOutputStream("books.dom4j.xml");
		
		XMLWriter writer = new XMLWriter(out);
		//添加内容对象
		writer.write(document);
		//关闭流
		writer.close();
		
		
		
	}
	public static void delete(String[] args) throws Exception {
		
		//获得document
		//获得解析流
		SAXReader reader = new SAXReader();
		//解析xml
		Document document  = reader.read("books.xml");
		
		
		
		//删除 b002
		Node bookNode = document.selectSingleNode("//book[@id='b002']");
		//获得父节点
		Node parent = bookNode.getParent();
		Element parentElement = (Element) parent;
		
		//删除操作
		parentElement.remove(bookNode);
		
		
		//将document保存
		//持久化流
		
		//创建输出文件的位置
		FileOutputStream out = new FileOutputStream("books.dom4j.xml");
		
		XMLWriter writer = new XMLWriter(out);
		//添加内容对象
		writer.write(document);
		//关闭流
		writer.close();
		
		
		
	}
	
	
	public static void update(String[] args) throws Exception {
		
		//获得document
		//获得解析流
		SAXReader reader = new SAXReader();
		//解析xml
		Document document  = reader.read("books.xml");
		
		
		
		//修改 b002 price 100
		Node bookNode = document.selectSingleNode("//book[@id='b002']");
		//强转转换
		Element bookElement = (Element) bookNode;
		//通过指定的名称获得相应的元素
		Element priceElement = bookElement.element("price");
		//修改值
//		priceElement.getText();
		priceElement.setText("100");
		
		
		//将document保存
		//持久化流
		
		//创建输出文件的位置
		FileOutputStream out = new FileOutputStream("books.dom4j.xml");
		
		XMLWriter writer = new XMLWriter(out);
		//添加内容对象
		writer.write(document);
		//关闭流
		writer.close();
		
		
		
	}

}
