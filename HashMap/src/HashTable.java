import java.util.LinkedList;

public class HashTable<K,V> {

    private LinkedList<Entry<K,V>> table [];
    private double load;

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + this.key + ", " + this.value + "]";
        }
    }

    public HashTable(int init, double loadFac){

        load = loadFac;
        table = new LinkedList[init];

        for(int i = 0; i < init; i++) {
            table[i] = new LinkedList<Entry<K, V>>();
        }

    }

    public V put(K key, V value){
        int index = key.hashCode() % size();
        if (get(key) == null){
            table[index].add(new Entry<>(key, value));
        }
        else{
            for (Entry e: table[index]){
                if (e.key.equals(key)){
                    e.setValue(value);
                }
            }
        }

        int counter = 0;
        for (LinkedList l: table){
            if (l.size() >= 1){
                counter++;
            }
        }

        if (counter/size() >= load){
            rehash();
        }

        return value;
    }

    public V get(K key){
        int index = key.hashCode() % size();
        for (Entry e: table[index]){
            if (e.key.equals(key)){
                return (V) e.value;
            }
        }
        return null;
    }

    public V remove(K key){
        V value = null;
        int index = key.hashCode() % size();
        if (get(key) == null){//key doesn't exist
            value = null;
        }
        else{
            for (Entry e: table[index]){
                if (e.key.equals(key)){
                    value = (V) e.getValue();
                    table[index].remove(e);
                }
            }
        }
        return value;
    }

    public int size(){
        return table.length;
    }

    @Override
    public String toString() {
        String str = "[";

        for (int i = 0; i < table.length; i++){
            str += table[i].toString() + ", ";
        }

        return str.substring(0, str.length()-2) + "]";

    }

    public void rehash(){
        LinkedList<Entry<K, V>> oldTable [] = table.clone();

        table = new LinkedList[oldTable.length*2];

        for (int i = 0; i < table.length; i++){
            table[i] = new LinkedList<Entry<K, V>>();
        }

        for (int x = 0; x < oldTable.length; x++){
            for (Entry e: oldTable[x]){
                K oldKey = (K) e.getKey();
                V oldValue = (V) e.getValue();
                put(oldKey, oldValue);
            }
        }
    }
}
