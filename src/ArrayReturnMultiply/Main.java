/***************************************************************************
 * Given a non-empty array of integers, return the result of multiplying the values together in order
 */
package ArrayReturnMultiply;

public class Main {
    public static void main(String[] args) {

        grow(new int[]{50,50});
    }

    public static int grow(int[] x) {
        int sum=1;
        for (int a : x) {
            if (a==0){
                System.out.println(0);
                return 0;
            }
            sum*=a;
        }
        System.out.println(sum);
        return sum;
    }
}
