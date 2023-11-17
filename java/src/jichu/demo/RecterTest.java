package demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RecterTest
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("demo.Student");
        Constructor constructor = aClass.getConstructor();
        Student o = (Student) constructor.newInstance();
        AnnotatedType[] annotatedInterfaces = aClass.getAnnotatedInterfaces();
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println(annotatedInterfaces.length);
        System.out.println(annotations.length);
    }
}
