package someelse;

/**
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class Factorial {
    private static long f1(long n){
        if (n<=0){
            throw new UnsupportedOperationException();
        }
        long sum=1;
        for (int i=1;i<n;i++){
            sum*=i;
        }
        return sum;
    }
    private static long f2(long n){
        if (n<=0){
            throw new UnsupportedOperationException();
        }
        if (n==1){
            return 1;
        }
        return n*f2(n-1);
    }
    public static void main(String[] args){
        System.out.println(f1(100));
    }
}
