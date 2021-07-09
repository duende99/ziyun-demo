package com.example.demo.api;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@EnableAspectJAutoProxy(proxyTargetClass = false)
public class Target {

    public static void main(String[] args) {
//        Person per = new Student();
//        Person person = (Person) Proxy.newProxyInstance(per.getClass().getClassLoader(), per.getClass().getInterfaces(), new JdkTarget(per));
//        person.getName();

//        Teacher teacher = new Teacher();
//        Teacher teacher1 = (Teacher) Enhancer.create(teacher.getClass(), (Callback) new Teacher());
//        teacher1.getName();
        Enhancer en = new Enhancer();
        en.setSuperclass(Teacher.class);
        en.setCallback(new CglibTarget());
        Teacher teacher = (Teacher) en.create();
        teacher.getName();
    }
}
class JdkTarget implements InvocationHandler {
    private Person person;
    public JdkTarget(Person per) {
        this.person = per;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(person, args);
        return method;
    }
    public void before() {
        System.out.println("before");
    }
}
class CglibTarget implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        return methodProxy.invokeSuper(o, objects);
    }
    public void before() {
        System.out.println("before");
    }
}
interface Person {
    void getName();
}
class Student implements Person {
    @Override
    public void getName() {
        System.out.println("name");
    }
}

class Teacher {
    public void getName() {
        System.out.println("name");
    }
}