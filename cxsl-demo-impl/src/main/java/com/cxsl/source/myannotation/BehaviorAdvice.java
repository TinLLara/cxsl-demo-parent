package com.cxsl.source.myannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class BehaviorAdvice {

    @Pointcut("execution(* com.cxsl.source.myannotation..*(..))")
    private void doSomething() {

    }

    /**
     * 前置通知
     */
    @Before("doSomething()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before behavior");
    }

    /**
     * 环绕通知 around advice
     * com.cxsl.source.myannotation包下面以及子包下 && 同时满足带有注解 BenzAfterSale
     */
    @Around(value = "(execution(* com.cxsl.source.myannotation..*(..))) && @annotation(benzAfterSale)", argNames = "joinPoint, benzAfterSale")
    public Object methodAround(ProceedingJoinPoint joinPoint, BenzAfterSale benzAfterSale) throws Throwable {
        System.out.println("Around method start.......................");
        String benzBehavior = benzBehavior();
        if (benzBehavior != null) {
            System.out.println("Around method " + benzBehavior);
        }
        //获得自定义注解的参数
        System.out.println("Around method benzAfterSale 的参数，remark：" + benzAfterSale.behavior());
        //执行目标方法，并获得对应方法的返回值
        Object result = joinPoint.proceed();
        System.out.println("Around method 返回结果：" + result);
        System.out.println("Around method end.......................");
        return result;
    }

    /**
     * 最终通知 after advice
     * 使用的是在上面声明的切面，并且带上个注解，意思是除了满足上面doSomething()方法的条件还得带上注解才OK
     */
    @After(value = "doSomething() && @annotation(benzAfterSale)", argNames = "joinPoint, benzAfterSale")
    public void methodAfter(JoinPoint joinPoint, BenzAfterSale benzAfterSale) throws Throwable {
        System.out.println("After method start.......................");
        //获得自定义注解的参数
        System.out.println("After method benzAfterSale 的参数，remark：" + benzAfterSale.behavior());
        BenzAfterSale remark = getMethodRemark(joinPoint);
        System.out.println("After method end.......................");
    }

    /**
     * 后置通知
     *
     */
    @AfterReturning(value = "(execution(* com.cxsl.source.myannotation..*(..))) && @annotation(benzAfterSale)", argNames = "joinPoint, benzAfterSale, result",
            returning = "result")
    public void methodAfterReturning(JoinPoint joinPoint, BenzAfterSale benzAfterSale, Object result) throws Throwable {
        System.out.println("AfterReturning method start.......................");
        System.out.println("AfterReturning method 返回的结果：" + result);
        String behavior = benzBehavior();
        if (behavior != null) {
            System.out.println("AfterReturning  " + behavior);
        }
        System.out.println("AfterReturning method end.......................");
    }

    private String benzBehavior() {
        return "change engine";
    }

    /**
     * 获取方法的中文备注____用于记录用户的操作日志描述
     */
    private BenzAfterSale getMethodRemark(JoinPoint joinPoint) throws Exception {
        //返回目标对象
        Object target = joinPoint.getTarget();
        String targetName = target.getClass().getName();
        //返回当前连接点签名
        String methodName = joinPoint.getSignature().getName();
        //获得参数列表
        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        //这个怎么这么low呢。
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    BenzAfterSale methodCache = m.getAnnotation(BenzAfterSale.class);
                    if (methodCache != null && !("").equals(methodCache.behavior())) {
                        return methodCache;
                    }
                    break;
                }
            }
        }
        return null;
    }
}