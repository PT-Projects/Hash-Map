public class Driver {
    public static void main(String[] args) {

        HashTable ht = new HashTable(2, .5);

        ht.put(1, "Hi");
        ht.put(2, "World");
        ht.put(3, "Die");
        ht.put(4, "World");
        ht.put(500, "TEST");

        for (int x = 1; x < 5; x++){
            System.out.println(ht.get(x));
        }

        System.out.println(ht.get(500));

        System.out.println(ht.size());

        System.out.println(ht.toString());

    }
}
