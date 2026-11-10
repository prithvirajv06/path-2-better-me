public class FindMaxProfit {

    private int findMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
