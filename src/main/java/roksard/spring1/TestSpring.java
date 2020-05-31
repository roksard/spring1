package roksard.spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBean testBean;
        TestBean testBean2;
        TestBean testBean3;
        try {
            testBean = context.getBean("testBean", TestBean.class);
            testBean2 = context.getBean("testBean", TestBean.class);
            testBean3 = context.getBean("testBean3", TestBean.class);
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
    }
}
