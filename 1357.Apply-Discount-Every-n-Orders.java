// https://leetcode.com/problems/apply-discount-every-n-orders/
// algorithms
// Medium (59.81%)
// Total Accepted: 3,019
// Total Submissions: 5,048


class Cashier {

    private int customers;
    private int n;
    private int discount;
    private HashMap<Integer, Integer> productToPrice = new HashMap<>();

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;

        initProductToPrice(products, prices);
    }

    private void initProductToPrice(int[] products, int[] prices) {
        for (int i = 0; i < products.length; i++) {
            productToPrice.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        this.customers++;

        int priceSum = 0;
        for (int i = 0; i < product.length; i++) {
            priceSum += productToPrice.get(product[i]) * amount[i];
        }

        double res;

        if (customers == n) {
            customers = 0;
            double tmp = (double) priceSum;
            res = tmp - (tmp * discount) / 100;
        } else {
            res = (double) priceSum;
        }

        return res;
    }
}

/**
 * Your Cashier object will be instantiated and called as such: Cashier obj =
 * new Cashier(n, discount, products, prices); double param_1 =
 * obj.getBill(product,amount);
 */