package Beanlifecycle.bean;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		StudentDao dao = new StudentDao();
//		dao.selectAllRows();
//		dao.deleteStudentRecord(5);
		
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//StudentDao dao = context.getBean("studentDAO",StudentDao.class);
		//System.out.println(dao);
		//dao.selectAllRows();
		Hello hello =  context.getBean("helloBean",Hello.class);
		hello.sample();
		((ClassPathXmlApplicationContext)context).close();
		
		//context.registerShutdownHook();
		//StudentDao dao1 = context.getBean("studentDAO",StudentDao.class);
	}
}
