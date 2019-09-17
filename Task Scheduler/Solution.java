class Solution {
    public int leastInterval(char[] tasks, int n) {
        // find parts
        // find slots
        // find available letters to be filled
        // find idle elements
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        
        for(int i=0;i<tasks.length;i++) {
            if(map.containsKey(tasks[i])) {
                
                int count = map.get(tasks[i])+1;
                if(count > maxFreq) {
                    maxFreq = count;
                }
                map.put(tasks[i], count);
            }
            else {
                map.put(tasks[i],1);
            }
        }
        
        for(int value: map.values()){
            if(value == maxFreq)
                maxCount++;
        }
        
        int parts = maxFreq - 1;
        int slots = (n-(maxCount - 1))* parts;
        int availableSlots = tasks.length - (maxCount * maxFreq);
        
        int idleSlots = Math.max(0, slots-availableSlots);
        
        return tasks.length + idleSlots;
    
    }
}