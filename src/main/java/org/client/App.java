package org.client;

import org.client.config.MyConfig;
import org.client.entity.People;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication",Communication.class);
        List<People> allPeople = communication.getAllPeople();
        System.out.println(allPeople);
//        People person = communication.getPerson(2);
//        System.out.println(person);
//        person.setDepartment("Another Department");
//        communication.savePerson(person);
//        People forTestPerson = new People("Kasha","Smirnova","WebDis", 325);
//        communication.savePerson(forTestPerson);
        communication.deletePerson(8);

    }
}
