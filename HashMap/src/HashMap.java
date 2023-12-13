import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K,V> {
    private final Integer capacity = 16;
    private final List<List<Entry<K,V>>> buckets = new ArrayList<>(capacity);
    private Integer size = 0;

    public HashMap(){
        for (int i = 0; i < capacity; i++) {
            buckets.add(i, new LinkedList<>());
        }
    }
    public void put(K key, V value){
        int hashcodeOfKey = key.hashCode();
        int indexOfBucket = hashcodeOfKey % capacity;
        List<Entry<K,V>> list = buckets.get(indexOfBucket);
        boolean isValuePresentedInList = false;

        for (int i = 0; i < list.size(); i++) {
            Entry<K,V> entry = list.get(i);
            if(entry.key.equals(key)){
                entry.setValue(value);
                return;
            }
        }
        list.add(new Entry(key,value));
        size++;
    }


    V get (K key){
        int hashcodeOfKey = key.hashCode();
        int indexOfBucket = hashcodeOfKey % capacity;

        List<Entry<K,V>> entries = buckets.get(indexOfBucket);

        for (int i = 0; i < entries.size(); i++) {
            Entry<K,V> entry = entries.get(i);
            if(entry.key.equals(key)){
                return entry.value();
            }
        }
        return null;
    }

    public static class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K key() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V value() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
