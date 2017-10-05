package template;
public class fib {

    // With complexity of O(2^n)
    public static int fib1(int n){
        if(n < 0) throw new IllegalArgumentException("Wrong number for fib");
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }
    
    // With Complexity of O(n)
    public static int fib2(int n){
        if(n < 0) throw new IllegalArgumentException("Wrong number for fib");
        int[] array = new int[n];
        for(int x = 0; x < array.length; x++){
            array[x] = x;
        }
        if(n == 0) return array[0];
        if(n == 1 || n == 2) return 1;
        return array[n - 1] + array[n - 2];
    }
    
    
    // with Complexity of O(n)
    public static int fib3(int n){
        if(n < 0) throw new IllegalArgumentException("Wrong number for fib");
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int first = 1, second = 1;
        int result = 0;
        for(int x = 3; x <= n; x++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
    
    
    
}
