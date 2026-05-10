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
        return sortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> sortHelper(List<Pair> pairs, int left, int right) {
        if (right - left + 1 <= 1) {
            return pairs;
        }
        int mid = left + (right - left) / 2;
        sortHelper(pairs, left, mid);
        sortHelper(pairs, mid + 1, right);
        return merge(pairs, left, mid, right);
    }

    public List<Pair> merge(List<Pair> pairs, int left, int mid, int right) {
        List<Pair> leftPairs = new ArrayList<>(pairs.subList(left, mid + 1));
        List<Pair> rightPairs = new ArrayList<>(pairs.subList(mid + 1, right + 1));
        int index = left;
        int index1 = 0;
        int index2 = 0;
        while (index1 < leftPairs.size() && index2 < rightPairs.size()) {
            if (leftPairs.get(index1).key <= rightPairs.get(index2).key) {
                pairs.set(index++, leftPairs.get(index1++));
            } else {
                pairs.set(index++, rightPairs.get(index2++));
            }
        }
        while (index1 < leftPairs.size()) {
            pairs.set(index++, leftPairs.get(index1++));
        }
        while (index2 < rightPairs.size()) {
            pairs.set(index++, rightPairs.get(index2++));
        }
        return pairs;
    }
}
