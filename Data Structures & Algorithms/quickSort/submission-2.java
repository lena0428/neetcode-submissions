// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortHelper(0, pairs.size() - 1, pairs);
        return pairs;
    }

    public void quickSortHelper(int left, int right, List<Pair> pairs) {
        if (right - left + 1 <= 1) {
            return;
        }
        Pair pivot = pairs.get(right);
        int i = left;
        for (int k = left; k <= right; k++) {
            if (pairs.get(k).key < pivot.key) {
                Pair tmp = pairs.get(k);
                pairs.set(k, pairs.get(i));
                pairs.set(i++, tmp);
            }
        }
        if (right != i) {
            pairs.set(right, pairs.get(i));
            pairs.set(i, pivot);
        }
        quickSortHelper(left, i - 1, pairs);
        quickSortHelper(i + 1, right, pairs);
    }
}
