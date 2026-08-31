class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;

        int position = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {

            ListNode next = curr.next;

            // Check whether curr is a critical point
            boolean isCritical =
                    (curr.val > prev.val && curr.val > next.val) ||
                    (curr.val < prev.val && curr.val < next.val);

            if (isCritical) {

                if (first == -1) {
                    // First critical point
                    first = position;
                } else {
                    // Distance from previous critical point
                    minDistance = Math.min(minDistance, position - last);
                }

                last = position;
            }

            prev = curr;
            curr = next;
            position++;
        }

        // Fewer than two critical points
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        int maxDistance = last - first;

        return new int[]{minDistance, maxDistance};
    }
}