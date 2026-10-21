package in.strikes.aopDemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcut {

        @Pointcut("within(in.strikes.aopDemo.controller ..* )")
       public void controllerLayer() { // emoty body
         }


         @Pointcut("within(in.strikes.aopDemo.service ..* )")
        public void serviceLayer() { // empty body
         }

         @Pointcut("execution(public * * (..))")
    public void publicMethod(){
            //emptyBody
         }

      @Pointcut("serviceLayer() && publicMethod()")
         public void publicServiceMethod(){
             // Empty
         }




}
