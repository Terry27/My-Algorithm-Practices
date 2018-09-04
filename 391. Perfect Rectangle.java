class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        //1. final 4 outer points occurs once, other points can occurs 2 or 4 times
        // sum of area = final rectangle area
        int ldX = Integer.MAX_VALUE; //left down X
        int ldY = Integer.MAX_VALUE;
        int rtX = Integer.MIN_VALUE; //top right X
        int rtY = Integer.MIN_VALUE;
        HashSet<String> set  = new HashSet<>();
        int sumArea = 0;
        for(int rec[]: rectangles){
            ldX = Math.min(ldX, rec[0]);
            ldY = Math.min(ldY, rec[1]);
            rtX = Math.max(rtX, rec[2]);
            rtY = Math.max(rtY, rec[3]);
            sumArea += (rec[2] - rec[0]) * (rec[3]- rec[1]); //total sum of rectangles
            String ld = rec[0] +"#"+ rec[1];
            String lt = rec[0] +"#"+ rec[3];
            String rd = rec[2] +"#"+ rec[1];
            String rt = rec[2] +"#"+ rec[3];
            if(!set.add(ld)){set.remove(ld);}
            if(!set.add(lt)){set.remove(lt);}
            if(!set.add(rd)){set.remove(rd);}
            if(!set.add(rt)){set.remove(rt);}
        }
        if(set.size() != 4 || !set.contains(ldX+"#"+ldY) || !set.contains(ldX+"#"+rtY) || !set.contains(rtX+"#"+rtY) || !set.contains(rtX+"#"+ldY)){return false;}
        return sumArea == (rtX - ldX)*(rtY- ldY);
    }
}