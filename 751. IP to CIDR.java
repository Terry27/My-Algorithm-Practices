class Solution {
    public List<String> ipToCIDR(String ipStr, int n) {
        String[] ips = ipStr.split("[.]"); //or "\\."
        int lowestBit = 0;
        long ip = 0;
        for(String s: ips){
            ip = ip*256 + Long.parseLong(s);
        }
        List<String> res = new ArrayList<>();
        while(n > 0){
            long step = ip & -ip; //lowestbit, fit it as many as possible
            while(step > n){step /= 2;}
            res.add(toIP(ip, step));
            ip += step;
            n -= step;
        }
        return res;
    }
    
    private String toIP(long ip, long step){
        long[] ips = new long[4];
        for(int i = 3; i >= 0; i--){
            ips[i] = ip % 256; //or &255
            ip /= 256; //or >>= 8
        }
        int len = 0;
        while(step > 0){
            step /= 2;
            len++;
        }
        return ips[0]+"."+ips[1]+"."+ips[2]+"."+ips[3]+"/"+(33-len);
    }
}