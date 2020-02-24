import java.util.HashMap;
import java.util.Map;

// begin at 2020/2/24 10:52
class Cashier {

    private int cnt, n, discount;
    private Map<Integer, Integer> prices = new HashMap<>();

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for(int i=0; i<products.length; i++)
            this.prices.put(products[i], prices[i]);
    }

    public double getBill(int[] product, int[] amount) {
        cnt++;
        double bill = 0;
        for (int i=0; i<product.length; i++){
            bill += amount[i]*prices.get(product[i]);
        }
        if(cnt == n){
            bill = bill - (discount * bill) / 100;
            cnt = 0;
        }

        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */

// finish at 2020/2/24 11:06
