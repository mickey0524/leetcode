// https://leetcode.com/problems/product-of-the-last-k-numbers/
// algorithms
// Medium (32.78%)
// Total Accepted: 4,740
// Total Submissions: 14,460
// beats 100.0% of java submissions


class ProductOfNumbers {

    private List<Integer> l;

    public ProductOfNumbers() {
        this.l = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            l.clear();
            return;
        }

        int size = l.size();
        if (size == 0) {
            l.add(num);
        } else {
            l.add(num * l.get(size - 1));
        }
    }

    public int getProduct(int k) {
        int size = l.size();

        if (k > size) {
            return 0;
        } else if (k == size) {
            return l.get(size - 1);
        } else {
            return l.get(size - 1) / l.get(size - 1 - k);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers(); obj.add(num); int param_2 =
 * obj.getProduct(k);
 */