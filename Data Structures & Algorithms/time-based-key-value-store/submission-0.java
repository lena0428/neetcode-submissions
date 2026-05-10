class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
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
        Integer i = tmp.floorKey(timestamp);
        if (i == null) {
            return "";
        }
        return tmp.get(i);
    }
}
