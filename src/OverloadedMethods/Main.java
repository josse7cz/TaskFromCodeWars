package OverloadedMethods;

public class Main {
    public static void main(String[] args) {
        System.out.println(add(5,6,8));
    }
    static int add(int x, int y){
        return x+y;

    }
    static int add(int x, int y,int z){
        return x+y+z;

    }

}
