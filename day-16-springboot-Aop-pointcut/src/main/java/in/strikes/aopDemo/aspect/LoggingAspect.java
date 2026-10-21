package in.strikes.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // * -> return type wagera khud dekh lega method ko padgh karr
    // .. -> argument kitna bhi ho 0 - infinity
    // .. -> agar kisi package ke andar package h or hume usse bhi map karna h then use
              //yeh * ke case me nhi hota

//    @Before("execution(public String in.strikes.aopDemo.service.StudentService.getStudent(..))")
//    public void logBeforeMethod(){
//
//        System.out.println("Method Intercepted");
//    }

    //StudentService class ke kisi methods ko map karega

//    @Before("execution(* in.strikes.aopDemo.service.StudentService.*(*))")
//    public void logBeforeMethod2(){
//        System.out.println("Method Intercepted 2");
//    }

    //StudentService class ke Get se start hone wale methods ko map karega

//    @Before("execution(* in.strikes.aopDemo.service.StudentService.get*(*))")
//    public void logBeforeMethod2(){
//        System.out.println("Method Intercepted 2");
//    }


    // Kisis bhi method se map karegi
//@Before("execution(* *(*))")
//public void logBeforeMethod2(){
//    System.out.println("Method Intercepted 2");
//}

    // Yeh pura project ke harr method ke saath map karta h
    // isilye yeh abhi error dega kyunki springboot hrr method ki proxy bnane ko dekhega
    // jo pssbl nhi h
//@Before("execution(* *(..))")
//public void logBeforeMethod2(){
//    System.out.println("Method Intercepted 2");
////}
//    // so
//    @Before("execution(* in.strikes.aopDemo..*(..))")
//    public void logBeforeMethod2(){
//        System.out.println("Method Intercepted 2");
//    }

    @Before("within(in.strikes.aopDemo.service..*)"+
    "&&" +
    "execution(public * *(..))")
    public void logBeforeMethod(){
        System.out.println("Method Intercepted");
    }

// 3-> @annotation
//    @Before("@annotation(jdk.jfr.Timestamp)")
//        public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    // 4-> bean
//@Before("bean(studentService) || bean(studentController)")
//public void logBeforeMethod(){
//    System.out.println("Method Intercepted");
//}


}
