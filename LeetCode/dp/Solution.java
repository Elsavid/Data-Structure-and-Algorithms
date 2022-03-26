//Dynamic Programming
/*This is a classic knapsack problem. Honestly, I'm not good at knapsack problem, it's really tough for me.

        dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
        State transition:

        not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
        using the ith coin, since we can use unlimited same coin, we need to know how many ways to make up amount j - coins[i-1] by using first i coins(including ith), which is dp[i][j-coins[i-1]]
        Initialization: dp[i][0] = 1*/
class Solution {
    public int change(int amount, int[] coins) {
        //my solution
        int[][] sum = new int[coins.length+1][amount+1];
        for(int i = 0;i<=coins.length;i++){
            sum[i][0] = 1;
        }
        for(int i = 0;i<=amount;i++){
            sum[0][i] = 0;
        }
        for(int i = 1;i<=coins.length;i++){
            for(int j = 1;j<=amount;j++){
                if(j<coins[i-1]){
                    sum[i][j] = sum[i-1][j];
                }else{
                    sum[i][j] = sum[i-1][j] + sum[i][j-coins[i-1]];
                }
            }
        }
        //optimal code style from leetcode
        public int change2(int amount, int[] coins) {
            int[][] dp = new int[coins.length+1][amount+1];
            dp[0][0] = 1;

            for (int i = 1; i <= coins.length; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= amount; j++) {
                    dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
                }
            }
            return dp[coins.length][amount];
        }
        // for(int i=0;i<=coins.length;i++){
        //     for(int j=0;j<=amount;j++){
        //         System.out.print(sum[i][j]+" ");}
        //     System.out.println();
        // }
        return sum[coins.length][amount];
    }
    //using only one array
         public int change3(int amount, int[] coins) {
         int[] dp = new int[amount + 1];
         dp[0] = 1;
         for (int coin : coins) {
             for (int i = coin; i <= amount; i++) {
                 dp[i] += dp[i-coin];
             }
         }
         return dp[amount];
     }
}