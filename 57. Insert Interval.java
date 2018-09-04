/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        //start
        while(i<intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i++));
        }
        
        //merged
        Interval merged = new Interval(newInterval.start, newInterval.end);
        while(i < intervals.size() && intervals.get(i).start <= merged.end){
            merged.start = Math.min(intervals.get(i).start, merged.start);
            merged.end = Math.max(intervals.get(i).end, merged.end);
            i++;
        }
        
        res.add(merged);
        //end
        while(i < intervals.size()){
            res.add(intervals.get(i++));
        }
        
        return res;
        
    }
}