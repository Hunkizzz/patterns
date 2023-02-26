package test;

public class Test {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.get();
    }
}

class Parent {
    Parent get() {
        System.out.println(1);
        return new Parent();
    }
}

class Child extends Parent {
    @Override
    Child get() {
        System.out.println(2);
        return new Child();
    }
}