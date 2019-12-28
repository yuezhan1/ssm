
import dao.AccountMapper;
import dao.RecordMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Account;
import pojo.Record;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ContextTest {
    @Test
    public void test() {
        float amount = 20f;
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        AccountMapper accountMapper = applicationContext.getBean("accountMapper", AccountMapper.class);
        RecordMapper recordMapper = applicationContext.getBean("recordMapper", RecordMapper.class);

        accountMapper.delete("target");
        accountMapper.delete("source");

        accountMapper.insert(Account.builder().account("target").balance(120f).build());
        accountMapper.insert(Account.builder().account("source").balance(100f).build());

        Account target = accountMapper.select("target");
        Account source = accountMapper.select("source");

        System.out.println(target);
        System.out.println(source);

        recordMapper.insert(Record.builder().sourceAccount(source.getAccount()).targetAccount(target.getAccount()).amount(amount).build());
        accountMapper.update(Account.builder().account(target.getAccount()).balance(target.getBalance() + amount).build());
        accountMapper.update(Account.builder().account(source.getAccount()).balance(source.getBalance() - amount).build());

        target = accountMapper.select("target");
        source = accountMapper.select("source");

        System.out.println(target);
        System.out.println(source);
    }

    @Test
    public void jdbcTest() {
        float amount = 20f;
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        AccountMapper accountMapper = applicationContext.getBean("accountJDBC", AccountMapper.class);
        RecordMapper recordMapper = applicationContext.getBean("recordJDBC", RecordMapper.class);

        accountMapper.delete("target");
        accountMapper.delete("source");

        accountMapper.insert(Account.builder().account("target").balance(120f).build());
        accountMapper.insert(Account.builder().account("source").balance(100f).build());

        Account target = accountMapper.select("target");
        Account source = accountMapper.select("source");

        System.out.println(target);
        System.out.println(source);

        recordMapper.insert(Record.builder().sourceAccount(source.getAccount()).targetAccount(target.getAccount()).amount(amount).build());
        accountMapper.update(Account.builder().account(target.getAccount()).balance(target.getBalance() + amount).build());
        accountMapper.update(Account.builder().account(source.getAccount()).balance(source.getBalance() - amount).build());

        target = accountMapper.select("target");
        source = accountMapper.select("source");

        System.out.println(target);
        System.out.println(source);
    }
}
