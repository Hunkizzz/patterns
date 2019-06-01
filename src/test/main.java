package test;

public class main {
    public static void main(String[] args){
        //String a = "a";
       // String b = new String("a");
        String b = new String("a");
        String a = b.intern();
        System.out.println(b==a);
        System.out.println(a.equals(b));
    }
}
