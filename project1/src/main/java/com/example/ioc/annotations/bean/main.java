package com.example.ioc.annotations.bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
   /**
    * Việc tạo các đối tượng nó không cần quan tâm thứ tự vì spring hỗ trợ thứ tự khởi 
    tạo dựa trên tình phụ thuộc rồi
    * 
    **/
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext();
        
        // context.registerBean("daylabeanrieng",Vehicle.class,()->{
        //     System.out.println("dang ky o day");
        //     return new Vehicle();
        // });
        context.register(Config.class);
       
        context.refresh();
        System.out.println("before");
        Vehicle vehicle = context.getBean(Vehicle.class);
        vehicle.setName("achan");
        Person person = context.getBean(Person.class);
        person.setName("amen");
        Person person1 = context.getBean(Person.class);

        System.out.println("Person name from Spring Context is: " + person1.getName());
        // System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());
        System.out.println("Vehicle that Person own is: " + person.getVehicle().getName());
        person1.getVehicle().setName("nichan");
        System.out.println("Vehicle that Person own is: " + person.getVehicle().getName());
        System.out.println("Vehicle that Person1 own is: " + person1.getVehicle().getName());

        person.setName("amen1");

        System.out.println("Person name from Spring Context is: " + person1.getName());

        System.out.print(person == person1);

    }
}