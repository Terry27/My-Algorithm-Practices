public class Solution {  //WITH extra space
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return result;
        }
        intervals.sort((Interval a, Interval b)->a.start-b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval: intervals){
            if(interval.start<=end){
                end = Math.max(end,interval.end);
            }else{
                result.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }
}

public class Solution { //in place
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0){
            return intervals;
        }
        intervals.sort((Interval i1, Interval i2)->i1.end - i2.end);
        int size = intervals.size();
        for(int i=size-1;i>0;i--){ //move backwards
            Interval before = intervals.get(i-1), current = intervals.get(i);
            if(before.end >= current.start){
                before.start = Math.min(current.start, before.start);
                before.end = current.end;
                intervals.remove(current);
            }
        }
        
        return intervals;
    }
}