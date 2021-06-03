package com.example.demo.JProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created by zc  2020/11/16 18:25
 */
public class AddServiceHandler implements InvocationHandler {

    private Object bean;
    private Method method;

    public AddServiceHandler(Object bean) {
        this.bean = bean;
    }

    public AddServiceHandler(Object bean, Method method) {
        this.bean = bean;
        this.method = method;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = this.method.invoke(bean, "超");
        System.out.println("after");
        return invoke;
    }

    public static AddService getProxy(Object bean) {
        AddServiceHandler addServiceHandler = new AddServiceHandler(bean);
        ClassLoader classLoader = bean.getClass().getClassLoader();
        Class[] clazz = {AddService.class};
        return (AddService) Proxy.newProxyInstance(classLoader, clazz, addServiceHandler);
    }

    public static SubtractService getProxy_two(Object bean) {
        AddServiceHandler addServiceHandler = new AddServiceHandler(bean);
        ClassLoader classLoader = bean.getClass().getClassLoader();
        Class[] clazz = {SubtractService.class};
        return (SubtractService) Proxy.newProxyInstance(classLoader, clazz, addServiceHandler);
    }


    public static MultiplyService getProxy_str(Object bean,Method method) throws NoSuchMethodException {
        AddServiceHandler addServiceHandler = new AddServiceHandler(bean,method);
        ClassLoader classLoader = bean.getClass().getClassLoader();
        Class[] clazz = {MultiplyService.class};
        return (MultiplyService) Proxy.newProxyInstance(classLoader, clazz, addServiceHandler);
    }

}
