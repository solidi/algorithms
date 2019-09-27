import java.util.Arrays;

/**
 * 1. A basic hash table with hash function that places the integers in their
 * place.
 *
 * 2. A more advanced hash where we want to place the same amount of integers,
 * but much higher values.
 */
public class Solution {

    public static class HashFunction {
        private String hashTable[];

        public HashFunction(int sizeOfTable) {
            hashTable = new String[sizeOfTable];
            Arrays.fill(hashTable, "-1");
        }

        public void putValues(String values[]) {
            for (int i = 0; i < values.length; i++) {
                String valueToInsert = values[i];
                int hashIndex = hashFunction2(values[i]);
                String valueIn = hashTable[hashIndex];

                while (valueIn != "-1") {
                    hashIndex++;
                    valueIn = hashTable[hashIndex];
                }

                hashTable[hashIndex] = valueToInsert;
            }
        }

        public int findValue(String key) {
            int hashIndex = hashFunction2(key);
            String value = hashTable[hashIndex];

            while (value != "-1") {
                if (hashTable[hashIndex] == key) {
                    return hashIndex;
                }

                ++hashIndex;
                hashIndex %= hashTable.length;
                value = hashTable[hashIndex];
            }

            return -1;
        }

        private int hashFunction1(String value) {
            return Integer.parseInt(value);
        }

        private int hashFunction2(String value) {
            return Integer.parseInt(value) % 29;
        }

        public void print() {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Key: " + i + " Value: " + hashTable[i]);
            }
        }
    }

    public static void main(String args[]) {
        String[] values2 = { "100", "510", "170", "214", "268", "398", "235", "802", "900", "723", "699", "1", "16",
                "999", "890", "725", "998", "978", "988", "990", "989", "984", "320", "321", "400", "415", "450", "50",
                "660", "624" };

        HashFunction hashFunction = new HashFunction(30);
        hashFunction.putValues(values2);
        hashFunction.print();

        System.out.println();
        System.out.println("Value is found in index: " + hashFunction.findValue("50"));
    }
}
