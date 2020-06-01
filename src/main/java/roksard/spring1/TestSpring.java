package roksard.spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBean testBean;
        TestBean testBean2;
        TestBean testNewBeanCreated;
        TestBean testDefaultConstructor;
        TestBean testPassIntValueIntoConstructor;
        TestBean testPassIntValueAndTypeToConstructor;
        try {
            testBean = context.getBean("testBean", TestBean.class);
            testBean2 = context.getBean("testBean", TestBean.class);
            testNewBeanCreated = context.getBean("testNewBeanCreated", TestBean.class);
            testDefaultConstructor = context.getBean("testDefaultConstructor", TestBean.class);
            testPassIntValueIntoConstructor = context.getBean("testPassIntValueIntoConstructor", TestBean.class);
            testPassIntValueAndTypeToConstructor = context.getBean("testPassIntValueAndTypeToConstructor", TestBean.class);
        } finally {
            context.close();
        }
        System.out.println("testBean: " + testBean.getName());
        System.out.println("testBean2: " + testBean2.getName());
        System.out.println("(testBean and testBean2 is same bean object)");
        System.out.println("testBean.setName(\"no more\")");
        testBean.setName("no more");
        System.out.println("testBean: " + testBean.getName());
        System.out.println("testBean2: " + testBean2.getName());
        System.out.println("(both changed name)");
        System.out.println("testNewBeanCreated: " + testNewBeanCreated.getName() + " (should be another bean object created)");
        System.out.println("testDefaultConstructor: " + testDefaultConstructor.getName() + " (default constructor)");
        System.out.println("testPassIntValueIntoConstructor: " + testPassIntValueIntoConstructor.getName()
                + " (pass '25' to constructor, but its treated as string)");
        System.out.println("testPassIntValueAndTypeToConstructor: " + testPassIntValueAndTypeToConstructor.getName()
                + " (pass value='25', type='int' to constructor, should produce 'N25')");
    }
}
