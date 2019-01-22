package com.test.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.test.stream.bean.Student;

public class SerializationObjectTest {

	public static void main(String[] args) {
		
		try {
			//文件输出流，到目的地student.txt文件，此处我们创建了一个缓冲流，这样更有效率，一般推荐使用缓冲流。如果文件不存在，那么则创建一个
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("student.txt"));
			//对象输出流,此时的对象Student必须序列化
			ObjectOutputStream os = new ObjectOutputStream(bos);
			Student stu = new Student("gh", 11, "成都");
			//将序列化的对象写到输出流中
			os.writeObject(stu);
			//关闭对象输出流
			os.close();
			
			//文件输入流，到文件student.txt文件去读取
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("student.txt"));
			//对象输入流
			ObjectInputStream is = new ObjectInputStream(bis);
			//将读取的对象转化为我们需要的对象
			Student s = (Student) is.readObject();
			//关闭对象输入流
			is.close();
			System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
