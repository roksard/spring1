package roksard.spring1;

public class TestBean {
    private String name;
    private static int count = 0;
    private int id = count++;
    {
        System.out.println(this.getClass().getSimpleName()  + " id=" + id + " created.");
    }

    public TestBean() {
        this.name = "Default";
    }

    public TestBean(String name) {
        this.name = name;
    }

    public TestBean(int nameN) {
        this.name = "N"+nameN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
