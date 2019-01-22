package cn.itcast.dom4j;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.itcast.domain.Book;

public class Dom4jTest {
	
	public static void main(String[] args) throws Exception {
		
		//需要List 存放所有的book对象
		List allBook = new ArrayList();
		
		//获得解析流
		SAXReader reader = new SAXReader();
		//xml文件的解析
		Document document = reader.read("books.xml");
		//获得根元素
		Element rootElement = document.getRootElement();
		//获得所有的书籍
		List list = rootElement.elements();
		//遍历所有的书籍 -- list
		for(int e = 0 ; e < list.size() ; e ++){
			//创建book对象
			Book book = new Book();
			//获得每一本book元素
			Element bookElement = (Element)list.get(e);
			//获得书籍的id属性值
			String id = bookElement.attributeValue("id");
			//System.out.println(id);
			book.setId(id);
			
			//获得title和price
			List childList = bookElement.elements();
			//遍历子元素
			for(int c = 0 ; c < childList.size() ; c ++){
				//获得每一个子元素
				Element child = (Element) childList.get(c);
//				System.out.println(child);
				//获得子元素文本内容
				String content = child.getText();
				//判断是否是title
				if("title".equals(child.getName())){
					book.setTitle(content);
				}
				//判断是否是price
				if("price".equals(child.getName())){
					book.setPrice(content);
				}
				
				
			}
			
			//将已经封装了内容的book对象，添加到list中
			allBook.add(book);
		}
		
		
		//程序解析前，输出内容
		System.out.println(allBook);
		
	}

}
