package com.example.ioc.annotations.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/** @Configuration dùng để chạy các bean khi khởi tao.
 *  @Bean cho phép thay thế trình khởi tạo
 *  @Component thì cho phép chỉ định tự khởi tạo
 *  @ComponentScan thì cho phép chỉnh định các package chứa component 
 *  thứ tự Bean không quan trọng spring sẽ tìm xem lớp nào phụ thuộc lớp nào. Và khởi tạo theo đúng 
 * thứ tự
 *  -- @Lazy , @Lazy(false) // mặc định
 * thì khi tạo context và refresh thì nó chưa tạo ra khi nào sử dụng đến các phương thức của lớp phụ thuộc
 * hoặc getBean mới tạo ra
**/
@Configuration
@Lazy

@ComponentScan(basePackages = "com.example.ioc.annotations.bean")
public class Config {
    // @Bean
    // // public Person person(Vehicle vehicle) {
    // //     Person person = new Person();
    // //     person.setName("Lucy");
    // //     person.setVehicle(vehicle);
    // //     return person;
    // // }
    // @Bean
    // Vehicle vehicle1() {
    //     var veh = new Vehicle();
    //     veh.setName("Audi");
    //     return veh;
    // }

    // @Bean
    // Vehicle vehicle2() {
    //     var veh = new Vehicle();
    //     veh.setName("Honda");
    //     return veh;
    // }
    // @Primary
    // @Bean
    // Vehicle vehicle3() {
    //     var veh = new Vehicle();
    //     veh.setName("Ferrari");
    //     return veh;
    // }

    /*
    Here in the below code, we are trying to wire or establish a relationship between Person
    and Vehicle, by passing the vehicle as a method parameter to the person() bean method.

    Spring injects the vehicle bean to the person bean using Dependency Injection. Spring will
    make sure to have only 1 vehicle bean is created and also vehicle bean will be created
    first always as person bean has dependency on it.

    * */
   

}
