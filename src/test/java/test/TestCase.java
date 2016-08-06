package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zp.cloudnote.dao.BookDAO;
import com.zp.cloudnote.dao.UserDAO;
import com.zp.cloudnote.entity.Book;
import com.zp.cloudnote.entity.User;

public class TestCase {
	private String[]conf={"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
	private ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	
	@Test
	public void test1(){
		UserDAO dao=ac.getBean("userDAO",UserDAO.class);
		User user=dao.findByName("demo");
		System.out.println(user);
		
	}
	

}
