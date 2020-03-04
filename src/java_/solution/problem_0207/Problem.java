package java_.solution.problem_0207;

public class Problem {

    public static long solve() {
        int partitions = 1;
        int perfect = 1;
        long m = 2;

        for (int a = 3; partitions / (double) perfect <= 12345; a++) {
            double t = Math.log(a) / Math.log(2);
            m = (long) a * a - a;
            partitions++;
            if (t % 1 == 0) {
                perfect++;
            }
        }

        return m;
    }

//    public static long solve2() {
//        long n = 3;
//        for (double perfect = 1; (n -1) / perfect <= 12345; n++) {
//            if ((n & n - 1) == 0) {
//                perfect++;
//            }
//        }
//        return n * n - n;
//    }
}
