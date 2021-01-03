// https://leetcode.com/problems/maximum-units-on-a-truck/
// algorithms
// Easy (72.41%)
// Total Accepted: 5,554
// Total Submissions: 7,670


class Solution {
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Item> list = new ArrayList<>(boxTypes.length);
        
        for (int[] b : boxTypes) {
            list.add(new Item(b[0], b[1]));
        }
        
        Collections.sort(list);
        
        int res = 0;
        for (Item item : list) {
            int tmp = Math.min(truckSize, item.num);
            res += item.unit * tmp;
            
            truckSize -= tmp;
            
            if (truckSize <= 0) {
                break;
            }
        }
        
        return res;
    }
    
    class Item implements Comparable<Item> {
        
        private int unit;
        
        private int num;
        
        public Item(int num, int unit) {
            this.unit = unit;
            this.num = num;
        }
        
        public int compareTo(Item o) {
            if (this.unit > o.unit) {
                return -1;
            } else {
                return 1;
            }
        }
        
    }
    
}