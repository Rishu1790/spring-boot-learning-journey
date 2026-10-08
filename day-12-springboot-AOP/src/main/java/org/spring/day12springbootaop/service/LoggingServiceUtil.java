package org.spring.day12springbootaop.service;

import org.spring.day12springbootaop.dto.Student;

public class LoggingServiceUtil {
    public static void logStart(String className,String methodNAme){
        System.out.println("Executing -> "+ className +" : "+ methodNAme);


    }
    public static void logEnd(String className,String methodNAme){
        System.out.println("Finishing -> "+ className +" : "+ methodNAme);


    }
}
