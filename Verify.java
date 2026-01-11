class Verify {
    public static void main(String[] a) {
        System.out.println(new Helper().calc(10, 5));
    }
}

class Helper {
    int[] data;
    public int calc(int num, int factor) {
        int res;
        if (num < factor) {
            res = factor - num;
        } else {
            res = num + factor * 2;
        }
        return res;
    }
}
