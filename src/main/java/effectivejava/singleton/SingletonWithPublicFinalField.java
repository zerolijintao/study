package main.java.effectivejava.singleton;

// Singleton with public final field
public class SingletonWithPublicFinalField {
    public final static SingletonWithPublicFinalField Instance = new SingletonWithPublicFinalField();
    private SingletonWithPublicFinalField(){
    }

    public void doThings(){
        System.out.println("Singleton with public final field");
    }
}

