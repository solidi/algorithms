import java.io.*;
import java.util.*;

/**
 * A company produces vehicles of three distinct type - bike, auto, and bus each
 * vehicle has a fixed number of wheels - 2, 4, and 6 respectively each vehicle
 * is identified with vehicle code - 1, 2, and 3 respectively
 * 
 * Based on input of number of persons travelling it gives the vehicle to use if
 * number of person travelling is <= 3, it returns vehicle as bike if number of
 * person travelling is > 3 and <= 8, it returns Vehicle as auto if number of
 * person travelling is > 8, it returns vehicle as bus
 * 
 * Write code which takes number of persons and prints vehicle type, vehicle
 * code and its number of wheels.
 */
class Solution {
    public static interface Transport {
        public String type();

        public int wheelCount();

        public int code();
    }

    public static class Bike implements Transport {
        public String type() {
            return "Bike";
        }

        public int wheelCount() {
            return 2;
        }

        public int code() {
            return 1;
        }

        public String toString() {
            return type() + " -> " + wheelCount() + " -> " + code();
        }
    }

    public static class Auto implements Transport {
        public String type() {
            return "Auto";
        }

        public int wheelCount() {
            return 4;
        }

        public int code() {
            return 2;
        }

        public String toString() {
            return type() + " -> " + wheelCount() + " -> " + code();
        }
    }

    public static class Bus implements Transport {
        public String type() {
            return "Bus";
        }

        public int wheelCount() {
            return 6;
        }

        public int code() {
            return 3;
        }

        public String toString() {
            return type() + " -> " + wheelCount() + " -> " + code();
        }
    }

    public static class TransportIdentifier {
        public static Transport identify(int numberOfPersons) {
            if (numberOfPersons <= 3) {
                return new Bike();
            } else if (numberOfPersons <= 8) {
                return new Auto();
            }

            return new Bus();
        }
    }

    public static void main(String args[]) {
        System.out.println("People in transport is 3: " + TransportIdentifier.identify(3));
        System.out.println("People in transport is 6: " + TransportIdentifier.identify(6));
        System.out.println("People in transport is 10: " + TransportIdentifier.identify(10));
    }
}
