package arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxSumTwoNonOverlappingSubArray {

    public static void main(String[] args) {
        int[] arr = {6, 1, 4, 6, 3, 2, 7, 4};
        System.out.println(solution(arr, 3, 2));
    }

    public static int solution(int[] A, int K, int L) {
        if (!(A.length >= 2 && A.length <= 100)) {
            return -1;
        }

        if (K < 1 || L < 1) {
           return -1;
        }

        if (K > 99 || L > 99) {
           return -1;
        }

        int maxTotal = Integer.MIN_VALUE;

        if (A.length < (L + K)) {
            return -1;
        }

        if (A.length == K + L) {
            return Arrays.stream(A).sum();
        }

        int low = K < L ? K : L;
        int high = K > L ? K : L;

        List<DisjointSection> maxSumList = new ArrayList<DisjointSection>();
        List<DisjointSection> minSumList = new ArrayList<DisjointSection>();

        int count = 0;
        while (count <= A.length - low) {
            if (count <= (A.length - high)) {
                maxSumList.add(createDisjointSet(high, A, count));
            }
            minSumList.add(createDisjointSet(low, A, count));
            count++;
        }

        for (DisjointSection min : minSumList) {
            for (DisjointSection max : maxSumList) {
                if (max.noMatch(min.indexes) && min.noMatch(max.indexes)) {
                    int total = max.sum + min.sum;
                    if (total > maxTotal) {
                        maxTotal = total;
                    }
                }
            }
        }
        return maxTotal;
    }

    public static class DisjointSection {
        private Integer sum = 0;
        private Set<Integer> indexes = new HashSet<Integer>();

        public boolean noMatch(Set<Integer> keys) {
            return indexes.stream().filter(i -> keys.contains(i)).count() == 0;
        }

        @Override
        public String toString() {
            return "{" + sum + ", " + indexes + "}";
        }
    }

    public static DisjointSection createDisjointSet(int end, int[] A, int i) {
        DisjointSection disjointSection = new DisjointSection();
        for (int k = 0; k < end; k++) {
            disjointSection.sum += A[i + k];
            disjointSection.indexes.add(i + k);
        }
        return disjointSection;
    }
}