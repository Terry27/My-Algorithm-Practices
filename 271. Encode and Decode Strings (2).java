public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()+"#"+s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        while(idx < s.length()){
            int newIdx = s.indexOf("#", idx);
            int len = Integer.parseInt(s.substring(idx, newIdx));
            res.add(s.substring(newIdx+1, newIdx+1+len));
            idx = newIdx+1+len;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));