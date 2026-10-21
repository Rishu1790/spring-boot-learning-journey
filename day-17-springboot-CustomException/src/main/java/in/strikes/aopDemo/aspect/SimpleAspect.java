package in.strikes.aopDemo.aspect;

import in.strikes.aopDemo.annotation.TrackExecutionTime;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

    @Around("@annotation(trackExecutionTime)")
    public Object trackeExecutionTime(ProceedingJoinPoint joinPoint,
                                      TrackExecutionTime trackExecutionTime) throws Throwable {
        Long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }
        finally {
            Long endTime = System.currentTimeMillis();
            Long finalTime = endTime-startTime;

            String operation = trackExecutionTime.operation();
            if(operation.isBlank()){
                operation = joinPoint.getSignature().getName();

            }

            Long trackTime = trackExecutionTime.warnAfter();

            if(finalTime>=trackTime){
                System.out.println("Your Method Execution Time Is Slow :" +
                        "Time Taken by "+ operation + ": "+ finalTime);
            }
            else {
                System.out.println("Time Taken by "+ operation + ": "+ finalTime);
            }




        }

    }

}
