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
@Order(2)
public class LoggerAspect {

    @Pointcut("execution(* com.example.ioc.annotations.aop.model.Song.*(..))")
    public void pointCutMethod() {
    }

    @Before("pointCutMethod()")  // trước khi target method được gọi
    public void logBefore() {  
        System.out.println("Trước khi thuc thi ");
    }
    @AfterReturning(  // sau khi trả về kết quả nếu không lỗi trương ứng với try
         pointcut = "pointCutMethod()",
    returning = "result"
    )
    public void logResult(Object result) {
        System.out.println("Method returned: " + result);
    }

    @AfterThrowing(
         pointcut = "pointCutMethod()",
            throwing = "exc"
    )
    public void logThrow (Throwable exc) {
        System.out.println("sau khi thuc thi loi"+exc.getMessage());
    }
    @After("pointCutMethod()") // sau khi target method được gọi các cái @After.. khác được gọi giống như try catch finally đây là finally
    public void logAfter (){
        System.out.println("sau khi thuc thi");

    }
   
   
}
