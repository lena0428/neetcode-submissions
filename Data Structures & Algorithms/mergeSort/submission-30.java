// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeHelper(List<Pair> pairs, int left, int right) {
        if (right - left + 1 <= 1) {
            return pairs;
        }
        int mid = left + (right - left) / 2;
        mergeHelper(pairs, left, mid);
        mergeHelper(pairs, mid + 1, right);
        return merge(pairs, left, mid, right);
    }

    public List<Pair> merge(List<Pair> pairs, int left, int mid, int right) {
        List<Pair> L = new ArrayList<>(pairs.subList(left, mid + 1));
        List<Pair> R = new ArrayList<>(pairs.subList(mid + 1, right + 1));
        int index1 = 0;
        int index2 = 0;
        int index = left;
        while (index1 < L.size() && index2 < R.size()) {
            if (L.get(index1).key <= R.get(index2).key) {
                pairs.set(index++, L.get(index1++));
            } else {
                pairs.set(index++, R.get(index2++)); 
            }
        }
        while (index1 < L.size()) {
            pairs.set(index++, L.get(index1++));
        }
        while (index2 < R.size()) {
            pairs.set(index++, R.get(index2++)); 
        }
        return pairs;
    }
}
