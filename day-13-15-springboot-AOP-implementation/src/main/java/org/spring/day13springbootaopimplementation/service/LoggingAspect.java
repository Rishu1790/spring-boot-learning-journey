package org.spring.day13springbootaopimplementation.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.spring.day13springbootaopimplementation.studentdto.Student;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

@Component
@Aspect
public class LoggingAspect {

    @Around( value = "execution(* org.spring.day13springbootaopimplementation.service.StudentService.getStudent(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] argsValue = joinPoint.getArgs();

        String originalString = (String) argsValue[0];
        String modifiedString = originalString.toUpperCase();

        Object[] convertToArgs = {
                modifiedString
        };

         return  joinPoint.proceed(convertToArgs);



    }






//            @Around(value = "execution(* org.spring.day13springbootaopimplementation.service.StudentService.createStudent(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
//                // @Before -> before LOgic
//                System.out.println("Starting :"+joinPoint.getSignature().getName());
//
//                try{
//                    Object result = joinPoint.proceed();
//
//
//                    //@AfterReturning-> afterReturning Logic
//                    System.out.println("Execution Successful");
//
//                    return result;
//
//                } catch (Exception e) {
//
//                    //@AfterThrowing -> After Throwing Logic
//
//                    System.out.println("Execution Failed: "+ e.getMessage());
//                    throw e;
//                }
//                finally{
//
//                    //@After -> After Logic
//
//                    System.out.println("Execution Completed");
//                }
//
//            }



//    @AfterReturning(
//            value = "execution(" +
//                    "* org.spring.day13springbootaopimplementation.service.StudentService"+
//                     ".createStudent(..))",
//            returning = "result")
//  public void  longAfterReturningMethod(Student result) {
////        String s = "Target Method Return : " + result;
////        System.out.println(s);
//
//        result.setName("Rishu Is not my NAme");
//        result.setAge(102);
//        System.out.println("Intercepted createStudent()");
//
//    }

//    @Before("execution(String org.spring.day13springbootaopimplementation.service.StudentService.createStudent()) ")
//    public void longBeforeMethod(JoinPoint joinPoint){
//        Object[] arr = joinPoint.getArgs();
//        System.out.println("Student is Going to be saved");

////        boolean allowed = false;
////        if(!allowed){
////            throw new RuntimeException("Hey Runtime Exception throw karrdiya");
////        }

        
    }

