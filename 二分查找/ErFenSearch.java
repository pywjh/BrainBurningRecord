package 二分查找;

public class ErFenSearch {

    public static void main(String[] args) {

        Integer[] ary = new Integer[] {1, 3, 4, 56, 78, 99};
        int item = 3;

        int low = 0;
        int high = ary.length - 1;

        while (low <= high) {
            int midIndex = (low + high) / 2;
            int midValue = ary[midIndex];

            if (midValue == item) {
                System.out.println(midIndex);
                break;
            } else if (midValue < item) {
                low = midIndex + 1;
            } else {
                high = midIndex - 1;
            }
        }
    }
}
