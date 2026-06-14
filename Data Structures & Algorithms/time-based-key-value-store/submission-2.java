class TimeMap {
    
    HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tmp = map.get(key);
        if (tmp == null) {
            return "";
        }
        Integer time = tmp.floorKey(timestamp);
        if (time == null) {
            return "";
        }
        return tmp.get(time);
    }
}
