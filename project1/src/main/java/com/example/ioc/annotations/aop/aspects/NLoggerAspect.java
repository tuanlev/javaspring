package com.example.ioc.annotations.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
  * Khái báo @Aspect để sử dụng
  * @Pointcut sử dụng để tạo một phương thức tượng trưng để các advice tham chiếu cho dễ thay ví tham chiếu 
  * nhiều dòng
  * execution tương ứng với joinPoint nghĩa là mình sẽ thêm các advice vào đâu (thường là method)
  * cú pháp viết execution 
  execution(modifiers-pattern? return-type-pattern declaring-type-pattern method-name-pattern(param-pattern) throws-pattern?)
modifiers-pattern?: như public, private (không bắt buộc).

return-type-pattern: kiểu trả về, ví dụ void, *.

declaring-type-pattern: class hoặc package chứa phương thức.

method-name-pattern: tên phương thức, ví dụ save*, get*.

param-pattern: định nghĩa kiểu và số lượng tham số, ví dụ (..) cho bất kỳ số lượng.

throws-pattern: loại ngoại lệ mà phương thức có thể ném ra.     
*	Đại diện cho một phần tử bất kỳ (ví dụ: kiểu trả về, tên method, tên class)
..	Đại diện cho 0 hoặc nhiều package/con/hoặc tham số bất kỳ
(..)	Chấp nhận bất kỳ số lượng tham số nào, bất kỳ kiểu
(*)	Chấp nhận duy nhất 1 tham số, bất kỳ kiểu nào
(*, ..)	Bắt đầu bằng 1 tham số, theo sau là bất kỳ số lượng tham số nào
  *Danh sách advice

  * */
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class NLoggerAspect {

    @Pointcut("@annotation(com.example.ioc.annotations.aop.interfaces.logAspect)")
    public void pointCutMethod() {
    }

    @Around("pointCutMethod()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Thuc thi" + joinPoint.getSignature().getName());
        
        return  joinPoint.proceed(); 
    }
   
   
}
