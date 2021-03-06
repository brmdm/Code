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

        for (int i = k; i < parking.length; i++) {
            if (parking[i] == 0) {
                parking[i] = 1;
                return true;
            }
            counter--;
        }

        for (int i = 0; i < parking.length; i++) {
            if (parking[i] == 0) {
                parking[i] = 1;
                return true;
            } else if (counter == 0) {
                return false;
            }
            counter--;
        }
        return false;
    }

    public boolean depart(int k) {
        if (k < 0 || k > (parking.length - 1)){
            throw new IllegalArgumentException();
        }
        if (parking[k] == 1) {
            parking[k] = 0;
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        for (int i = 0; i < parking.length; i++) {
            System.out.print(parking[i]);
        }
    }
}

