package HackerRank;

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();

        System.out.println(s1.getSingleTonValue());
    }
}

class Singleton {
    private String str;
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public String getSingleTonValue() {
        str = "test";
        return str;
    }
}