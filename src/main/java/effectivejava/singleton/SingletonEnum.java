package main.java.effectivejava.singleton;

// Enum singleton - the preferred approach
public enum SingletonEnum {
    INSTANCE;

    public void doThings(){
        System.out.println("Enum singleton - the preferred approach");
    }
}
