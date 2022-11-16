package org.example.BinarySearch;

import java.io.File;
import java.io.IOException;

public class BinarySearch {

    public static void main(String[] args) throws IOException {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        System.out.println(binarySearch(a, 11));
/*
        String path = "/Users/ruaekm3/Documents/Java/"
                + LocalDate.now().getYear()
                + "/"
                + LocalDate.now().getMonth()
                + "/"
                + LocalDate.now().getDayOfMonth();

        System.out.println(path);
        System.out.println(printDate(path));

        try (final FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(1123111);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int hight = a.length - 1;

        while (low <= hight) {
            int middle = low + (hight - low) / 2;

            if (key < a[middle]) {
                hight = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static boolean printDate(String path) {
        File file = new File(path);
        return file.mkdirs();
    }
}
