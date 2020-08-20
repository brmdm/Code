package rd.java.basic.practice6.part3;

public class Parking {
    private int[] parking;
    private int counter;

    public Parking(int capacity) {
        this.parking = new int[capacity];
    }

    public boolean arrive(int k) {
        if (k < 0 || k > (parking.length - 1)){
            throw new IllegalArgumentException();
        }
        counter = parking.length;






        return false;
    }

    public boolean depart(int k) {
        if (k < 0 || k > (parking.length - 1)){
            throw new IllegalArgumentException();
        }
        if (parking[k] == 1) {
            parking[k] = 0;
            print();
            System.out.println(", true");
            return true;
        } else {
            print();
            System.out.println(", false");
            return false;
        }
    }

    public void print() {
        for (int i = 0; i < parking.length; i++) {
            System.out.print(parking[i]);
        }
    }
}

