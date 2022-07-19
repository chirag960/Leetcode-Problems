class Pair {
    int timestamp;
    String value;
    
    public Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {

    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<Pair>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair> list = map.get(key);
        if(list.size() == 1){
            return list.get(0).value;
        }
        
        int start = 0;
        int end = list.size() - 1;
        int mid = 0;
        while(start < end){
            mid = (start + end)/2;
            if(timestamp == list.get(mid).timestamp){
                return list.get(mid).value;
            }else{
                if(timestamp > list.get(mid).timestamp){
                    if(timestamp < list.get(mid+1).timestamp)
                        return list.get(mid).value;
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return list.get(start).timestamp <= timestamp ? list.get(start).value : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */