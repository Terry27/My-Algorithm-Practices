class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for(int i = 1; i <= N; i++){
            if(canRot(i)){
                res++;
            }
        }
        return res;
    }

    private boolean canRot(int num){
        int zoe = 0;
        int digits = 0;
        while(num > 0){
            int curNum = num%10;
            num /= 10;
            digits++;
            if(curNum == 3 || curNum == 4 || curNum == 7){
                return false;
            }
            if(curNum == 0 || curNum == 1 || curNum == 8){
                zoe++;
            }
        }
        if(zoe == digits){
            return false;
        }
        return true;
    }
}

//dp solution
//Using a int[] for dp.
//dp[i] = 0, invalid number
//dp[i] = 1, valid and same number
//dp[i] = 2, valid and different number
public int rotatedDigits(int N) {
    int[] dp = new int[N + 1];
    int count = 0;
    for(int i = 0; i <= N; i++){
        if(i < 10){
            if(i == 0 || i == 1 || i == 8) dp[i] = 1;
            else if(i == 2 || i == 5 || i == 6 || i == 9){
                dp[i] = 2;
                count++;
            }
        } else {
            int a = dp[i / 10], b = dp[i % 10];
            if(a == 1 && b == 1) dp[i] = 1;
            else if(a >= 1 && b >= 1){
                dp[i] = 2;
                count++;
            }
        }
    }
    return count;
}
