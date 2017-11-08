/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package template;

/**
 *
 * @author 611L2U1
 */
public class Template {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
 
public class Main {
    private static IO io = new IO();
 
    public static void main(String[] args) throws Exception {
        int t = io.getInt();
        while (t-- != 0) {
            int n = io.getInt();
            if(n == 2){
                System.out.println(3);
                continue;
            }
            else if(n == 0 || n == 1){
                System.out.println(1);
                continue;
            }
            long[][] mat = {{2, 2}, {1, 0}};
            long[][] pow = matrixPower(mat, n - 2);
            long ans = Utils.modAdd(3L*pow[0][0], pow[0][1]);
            System.out.println(ans);
        }
    }
 
    static long[][] matrixPower(long[][] base, long pow) {
        int N = base.length;
        long[][] ans = new long[N][N];
        for (int i = 0; i < N; i++) ans[i][i] = 1;
 
        while (pow != 0) {
            if ((pow & 1) != 0) ans = multiplyMatrix(ans, base);
 
            base = multiplyMatrix(base, base);
 
            pow >>= 1;
        }
 
        return ans;
    }
 
    static long[][] multiplyMatrix(long[][] m, long[][] m2) {
        int N = m.length;
        long[][] ans = new long[N][N];
 
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                ans[i][j] = 0;
                for (int k = 0; k < N; k++) {
                    ans[i][j] = Utils.modAdd(ans[i][j], Utils.modMul(m[i][k], m2[k][j])) ;
                }
            }
 
        return ans;
    }
}
 
class IO {
    private BufferedReader br = null;
    private StringTokenizer st = null;
 
    public IO() {
        this(System.in);
    }
 
    public IO(InputStream is) {
        this.br = new BufferedReader(new InputStreamReader(is));
    }
 
    public List<String> getStringArray(int n) throws IOException {
        if (n == 0)
            return new ArrayList<>();
        if (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            res.add(st.nextToken());
        }
        return res;
    }
 
    public String getString() throws IOException {
        List<String> res = this.getStringArray(1);
        return res.size() == 0 ? "" : res.get(0);
    }
 
    public List<Integer> getIntegerArray(int n) throws IOException {
        if (n == 0)
            return new ArrayList<>();
        List<String> res = getStringArray(n);
        return res.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
 
    public Integer getInt() throws IOException {
        List<Integer> res = this.getIntegerArray(1);
        return res.size() == 0 ? 0 : res.get(0);
    }
 
    public List<Long> getLongArray(int n) throws IOException {
        if (n == 0)
            return new ArrayList<>();
        List<String> res = getStringArray(n);
        return res.stream().map(Long::parseLong).collect(Collectors.toList());
    }
 
    public Long getLong() throws IOException {
        List<Long> res = this.getLongArray(1);
        return res.size() == 0 ? 0L : res.get(0);
    }
 
    public List<Double> getDoubleArray(int n) throws IOException {
        if (n == 0)
            return new ArrayList<>();
        List<String> res = getStringArray(n);
        return res.stream().map(Double::parseDouble).collect(Collectors.toList());
    }
 
    public Double getDouble() throws IOException {
        List<Double> res = this.getDoubleArray(1);
        return res.size() == 0 ? 0.0 : res.get(0);
    }
}
 
class Utils {
    static int[][] fourDirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] eightDirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
 
    static int modAdd(long a, long b) {
        return (int) ((a + b) % 1000000007);
    }
 
    static int modMul(long a, long b) {
        return (int) ((a * b) % 1000000007);
    }
 
    static int modSub(long a, long b) {
        return (int) ((a - b + 1000000007) % 1000000007);
    }
 
    public static List<Integer> sieve(int n) {
        boolean b[] = new boolean[n + 1];
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(b, true);
 
        for (int i = 2; i <= n; i++) {
            if (b[i]) {
                ans.add(i);
                for (int j = i * i; j >= 0 && j <= n; j += i) {
                    b[j] = false;
                }
            }
        }
        return ans;
    }
 
    public static boolean isPrime(long n) {
        long sqrt = (long) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
 
    public static long mod(long n) {
        if (n > 0)
            return n % 1000000007;
        return (n + 2000000014) % 1000000007;
    }
 
    public static boolean isSqr(long n) {
        int sqrt = (int) Math.sqrt(n);
        return n == (long) sqrt * sqrt;
    }
 
    public static boolean inRange(long i, long l, long h) {
        return i >= l && i <= h;
    }
 
    public static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
 
    public static void swap(List<Integer> ls, int i, int j) {
        int temp = ls.get(i);
        ls.set(i, ls.get(j));
        ls.set(j, temp);
    }
 
    public static long gcd(long a, long b) {
        if (a < b)
            return gcd(b, a);
        else if (a == b || b == 0)
            return a;
        else {
            return gcd(b, a % b);
        }
    }
 
    public static long subSum(long[] pre, int l, int h) {
        return l == 0 ? pre[h] : pre[h] - pre[l - 1];
    }
 
    public static void ifPrint(boolean test, Object ifValue, Object elseValue) {
        System.out.println(test ? ifValue : elseValue);
    }
 
    public static void print(Character delim, Object... a) {
        List<String> top = new ArrayList<>();
        for (Object aa : a)
            top.add(aa == null ? "null" : aa.toString());
        System.out.println(join(top, delim.toString()));
    }
 
    public static void print(Object... a) {
        print(' ', a);
    }
 
    public static <T extends Comparable<T>> int lowerBound(T[] arr, int l, int h, T key) {
        while (l < h) {
            int mid = (l + h) / 2;
            if (arr[mid].compareTo(key) < 0)
                l = mid + 1;
            else
                h = mid;
        }
        return arr[l].compareTo(key) >= 0 ? l : -1;
    }
 
    public static <T extends Comparable<T>> int upperBound(T[] arr, int l, int h, T key) {
        while (l < h) {
            int mid = (l + h) / 2;
            if (arr[mid].compareTo(key) < 0)
                l = mid + 1;
            else if (arr[mid].compareTo(key) == 0)
                l = mid;
            else
                h = mid;
            if (h == l + 1)
                break;
        }
        return arr[l].compareTo(key) >= 0 ? l : -1;
    }
 
    public static <T> String join(List<T> ls) {
        return join(ls, " ");
    }
 
    public static <T> String join(List<T> ls, String delim) {
        StringJoiner sj = new StringJoiner(delim);
        for (T a : ls)
            sj.add(a.toString());
        return sj.toString();
    }
 
    public static <T> void print2DArray(List<List<T>> mat) {
        for (List<T> m : mat) {
            System.out.println("{ " + join(m, ", ") + " }");
        }
    }
 
    public static <T> void reverseArrray(T[] arr, int l, int h) {
        while (l < h) {
            T temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++;
            h--;
        }
    }
} 
