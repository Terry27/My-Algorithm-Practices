class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == '+' && s.charAt(i) == '+'){
                list.add(s.substring(0,i-1)+"--"+s.substring(i+1));
            }
        }
        return list;
    }
}