package com.example.ioc.annotations.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
/**
 * @Autowired nó giống như việc cùng lúc thực thi việc gán chính ở đó còn đối tương
 * chỉ định sẽ là thể hiện vehicle trong config (bean)
 * mặc định bean scope là singleton thì thì khi tạo 1 context mình tạo các đối tượng ví dụ
 * v1, v2, v3... đi chăng nữa thì nó vẫn tham chiếu đến 1 cái khi v1 thay đổi field thì mình get field đó ở v2 
 * cũng cho cùng giá trị
 * 
 * */


@Component
public class Person {
    @Autowired
    public Person(@Lazy Vehicle vehicle1){ //@Qualifier("daylabeanrieng")
        this.vehicle = vehicle1;
        System.out.println("Person bean created by Spring");
    }
    
    private String name;
//    @Autowired  // nó sẽ thực ngay ở bước khởi tạo ở đây rất thần kỳ
    private Vehicle vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    // @Autowired
    public void setVehicle(Vehicle vehicle) {
        System.out.println("việc inject vehicle vào person sẽ được thự thi ở đây");
        this.vehicle = vehicle;
    }
}