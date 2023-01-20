package AddAndSubstract;

public class AddSubstract {

    AddSubstract() {
    }

    public int addAndSubstract(int a, int b, boolean signum){
        int sum;
        if (signum){
            sum=a+b;
            System.out.println(sum);
            return sum;

        }
        System.out.println(a-b);
        return a-b;
    }
}