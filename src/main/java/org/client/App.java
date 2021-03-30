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
        People person = communication.getPerson(2);
        System.out.println(person);
        People forTestPerson = new People("Pasha","Smirnov","HR", 325);
        communication.savePerson(forTestPerson);
        forTestPerson.setPeopleId(12);
        communication.savePerson(forTestPerson);
        communication.deletePerson(12);
    }
}
