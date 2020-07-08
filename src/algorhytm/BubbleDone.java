package algorhytm;

public class BubbleDone {
    public static int[] main(int[] a) {
//        int[] a = new int[(int) (Math.random() * 100)];


        int tech;
        boolean flag = false;



        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a.length; k++) {
                for (int j = 0; j < a.length - k - 1; j++) {
                    if (a[k] > a[k + 1]) {
                        tech = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = tech;
                    }
                }
            }
        }

//        System.out.println();
//        System.out.println("After Sorting");
//        for (int digit : a) {
//            System.out.print(digit + " | ");
//        }
        return a;
    }
}
