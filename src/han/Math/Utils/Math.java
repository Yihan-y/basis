package han.Math.Utils;

public class Math {
    
    /**
     * @description greatest common divisor
     * given a and b are non-negative integers
     *
     * brief explanation:
     * assuming gcd(a,b)=z, a must be divisible by z and so must b
     * And linear combination of a and b, ma±nb must also be divisible by z
     * a=xb+c -> c=a-xb which means c(a%b) must likewise be divisible by z
     * @date 2021/1/7
     */
    public static int gcd(int a, int b) {
        return b==0?a:gcd(b,a%b);
    }

    /**
     * @description least common multiple
     * @date 2021/1/7
     */
    public static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }

    public static boolean isPrime(int a) {
        if(a<=1) {
            return false;
        }
        for(int i=2;i*i<=a;i++) {
            if(a%i==0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @description convert decimal integer to n-base representation string
     * @date 2021/1/7
     */
    public static String convert2BaseN(int num, int n) {
        if(num==0) {
            return "0";
        }
        boolean negative=num<0;
        num=negative?-num:num;
        StringBuilder res=new StringBuilder();
        while(num!=0) {
            int cur=num%n;
            num/=n;
            res.append(cur);
        }
        if(negative) {
            res.append("-");
        }
        return res.reverse().toString();
    }

}
