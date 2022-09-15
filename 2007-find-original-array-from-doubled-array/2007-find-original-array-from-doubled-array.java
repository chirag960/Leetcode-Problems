class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 == 1){
            return new int[0];
        }
        
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        int[] original = new int[changed.length/2];
        for(int i : changed){
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        
        int index = 0;
        for(int num : frequencyMap.keySet()){
            if(frequencyMap.getOrDefault(num + num, 0) < frequencyMap.get(num)){
                return new int[0];
            }
            for(int i=0;i<frequencyMap.get(num);i++){
                original[index++] = num;
                frequencyMap.put(num+num, frequencyMap.get(num+num)-1);
            }
        }
        return original;
    }
}