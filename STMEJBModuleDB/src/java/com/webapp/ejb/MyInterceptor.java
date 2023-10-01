
package com.webapp.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


class MyInterceptor {
    @AroundInvoke
    public Object intersept(InvocationContext ic)throws Exception{
        System.out.println("MyInterceptor:intercep........");
        return ic.proceed();
    }
}

class MyInterceptor1 {
    @AroundInvoke
    public Object intercept(InvocationContext ic)throws Exception{
        System.out.println("MyInterceptor1:intercep........");
        return ic.proceed();
    }
}

class MyInterceptor2 {
    @AroundInvoke
    public Object intercept(InvocationContext ic)throws Exception{
        System.out.println("MyInterceptor2:intercep........");
        return ic.proceed();
    }
}