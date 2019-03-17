package code;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyAnnotationTest
{

	public static void main(String[] args) throws Exception
	{
		Class<AnnotationDemo> annotationDemoClass = AnnotationDemo.class;

		Method method = annotationDemoClass.getMethod("output", new Class[]{});

		if (method.isAnnotationPresent(MyAnnotation.class)) 
		{
			MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
			System.out.println(annotation.hello());
		}
	}

}




