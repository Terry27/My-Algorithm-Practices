public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strings){
            String key = shift(s);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
    
    private String shift(String s){
        int shiftVal = s.charAt(0)-'a';
        char[] temp = s.toCharArray();
        for(int i=0; i< temp.length;i++){
            temp[i] = (char)((temp[i]+26-shiftVal)%26); //+26!!!
        }
        return new String(temp);
    }
}