import java.io.*;
import java.util.*;

/**
 * Construct three vehicle types - bike, auto, and bus. 
 * Each vehicle has a fixed number of wheels - 2, 4, and 6.
 * Each vehicle is identified with vehicle code - 1, 2, and 3.
 * 
 * Based on number of people travelling, return the vehicle on these rules:
 * If <= 3, it return a bike.
 * If > 3 and <= 8, it returns an auto.
 * If > 8, it returns a bus.
 * 
 * Write code which takes number of persons and prints vehicle type, vehicle
 * code, and its number of wheels.
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
