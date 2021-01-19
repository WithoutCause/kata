package me.sjl;

import me.sjl.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        Person bean = beans.getBean(Person.class);
        System.out.println(bean);
        beans.close();
    }

}
