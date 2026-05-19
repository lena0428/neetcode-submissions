class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
            return 1 / helper(x, -n);
        } else {
            return helper(x, n);
        }
    }

    public double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double tmp = helper(x , n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        } else {
            return tmp * tmp * x;
        }
    }
}
