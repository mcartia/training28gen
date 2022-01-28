package it.training.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    //@Pointcut("execution(* it.training.spring.*.*(..))")
    @Pointcut("@annotation(it.training.spring.MyAudit)")
    public void myPointcut() throws Throwable {}

    @Before("myPointcut()")
    public void beforeAdvice(JoinPoint jp) throws Throwable {
        System.out.println("[MyAspect] beforeAdvice");
        System.out.println("Invoking method: "+jp.getSignature());
        for (Object arg : jp.getArgs()){
            System.out.println("+ arg: "+arg);
        }
    }

    @Around("myPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Before calling method: "+pjp.getSignature());
        Object[] args = pjp.getArgs();
        /*Object[] newArgs = new Object[args.length];
        int i = 0;
        for (Object o : args) {
            newArgs[i] = (int)o*2;
            i++;
        }*/
        Object ret = pjp.proceed(args);
        System.out.println("After executing method: "+pjp.getSignature());
        return ret;
    }

}
