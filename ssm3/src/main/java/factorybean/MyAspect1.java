package factorybean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect1 {
    public void myBefore(JoinPoint joinPoint){
        System.out.print("前置通知：模拟执行权限检查...，");
        System.out.print("目标是："+joinPoint.getTarget());
        System.out.println(",被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("后置通知：模拟记录日志...");
        System.out.println("被植入增强处理的目标方法为:"+joinPoint.getSignature().getName());
    }
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("环绕开始：执行目标方法之前，模拟开启任务...");
        Object object=proceedingJoinPoint.proceed();
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务...");
        return object;
    }
    public void myAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("异常通知："+"出错了"+ throwable.getMessage());
    }
    public void myAfter(){
        System.out.println("最终通知：模拟方法结束之后的释放资源");
    }
}
