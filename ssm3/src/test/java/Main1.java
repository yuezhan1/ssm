import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        String xmlPath="applicationContext1.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao=(UserDao) applicationContext.getBean("userDao");
        userDao.say();
    }
}
