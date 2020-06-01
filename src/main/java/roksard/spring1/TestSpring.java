package roksard.spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBean testBean;
        TestBean testBean2;
        TestBean testBean3;
        TestBean testBean4;
        TestBean testBean5;
        TestBean testBean6;
        try {
            testBean = context.getBean("testBean", TestBean.class);
            testBean2 = context.getBean("testBean", TestBean.class);
            testBean3 = context.getBean("testBean3", TestBean.class);
            testBean4 = context.getBean("testBean4", TestBean.class);
            testBean5 = context.getBean("testBean5", TestBean.class);
            testBean6 = context.getBean("testBean6", TestBean.class);
        } finally {
            context.close();
        }
        System.out.println("testBean: " + testBean.getName());
        System.out.println("testBean2: " + testBean2.getName());
        System.out.println("testBean.setName(\"no more\")");
        testBean.setName("no more");
        System.out.println("testBean: " + testBean.getName());
        System.out.println("testBean2: " + testBean2.getName());
        System.out.println("testBean3 (should be another bean object created): " + testBean3.getName());
        System.out.println("testBean4 (default constructor): " + testBean4.getName());
        System.out.println("testBean5 (pass '25' to constructor, but its treated as string): " + testBean5.getName());
        System.out.println("testBean6 (pass value='25', type='int' to constructor, should produce 'N25'): " + testBean6.getName());
    }
}
