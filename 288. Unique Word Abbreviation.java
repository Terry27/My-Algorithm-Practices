public class ValidWordAbbr {
    private HashMap<String, String> map = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for(String str: dictionary){
            String key = getAbbr(str);
            if(map.containsKey(key)){
                if(!map.get(key).equals(str)){
                    map.put(key,"");
                }
            }else{
                map.put(key,str);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getAbbr(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }
    
    private String getAbbr(String s){
        if(s.length()<=2){
            return s;
        }
        return s.charAt(0)+String.valueOf(s.length()-2)+s.charAt(s.length()-1);
    }
}
