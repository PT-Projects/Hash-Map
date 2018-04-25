public class Driver {
    public static void main(String[] args) {

        HashTable ht = new HashTable(4, .75);

        ht.put(1, "Hi");
        ht.put(2, "World");
        ht.put(3, "Die");
        ht.put(4, "World");

        System.out.println(ht.size());

        System.out.println(ht.toString());

    }
}
