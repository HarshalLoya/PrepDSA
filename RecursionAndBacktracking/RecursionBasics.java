
public class RecursionBasics {

    // public static int findSum(int n, int sum) {
    //     if(n < 1){
    //         return sum;
    //     }
    //     sum += n;
    //     return findSum(n - 1, sum);
    // }
    
    public static int findSum(int n) {
        if(n == 1) return 1;
        return n + findSum(n - 1);
    }
    public static void main(String[] args) {
        int n = 10;
        // int sum = findSum(n, 0);
        int sum = findSum(n);
        System.out.println(sum);
        System.out.println("Done");
    }
}
