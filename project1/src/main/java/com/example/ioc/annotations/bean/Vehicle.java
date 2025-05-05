package com.example.ioc.annotations.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/** 
 * khi kết hợp  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) với lazy thì sẽ gặp vấn dè là khi nó sẽ sinh ra nhiều 
 * biến thể của các lớp inject vì khi sử dụng nó sẽ khởi tạo với singleton là tham chiếu với khởi tạo tương đồng
 * còn prototype nó sẽ tạo mới tạo mới dẫn đến lỗi logic
 */
@Component

//  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Vehicle {
    private String name = "hi";
    public Vehicle () {
        System.out.println("Khoi tao vehicle");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        System.out.println("Vehicle change");
        this.name = name;
    }
}
