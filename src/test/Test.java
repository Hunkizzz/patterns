package test;

public class Test {
    public static void main(String[] args) {
        Parent parent = new Child();
    }
}

class Parent {
    Parent get() {
        return new Parent();
    }
}

class Child extends Parent {
    @Override
    Child get() {
        return new Child();
    }
}