public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()+"@"+s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i< s.length()){
            int nextIndex = s.indexOf("@", i);
            int wordL = Integer.parseInt(s.substring(i, nextIndex));
            res.add(s.substring(nextIndex+1, nextIndex+1+wordL));
            i = nextIndex+1+wordL;
        }
        return res;
    }
}

//不用delimiter的话，找出最大长度，每段使用固定长度前缀表示下一个string的length


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));