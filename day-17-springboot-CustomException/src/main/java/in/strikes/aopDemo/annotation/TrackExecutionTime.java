package in.strikes.aopDemo.annotation;

import java.lang.annotation.*;

// MArker Annotation

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {
    // Configured Annotation
    long warnAfter() default 2000;
    String operation() default "";



}
