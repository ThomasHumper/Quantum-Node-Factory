-- Define a linked list data structure
data LinkedList a = Empty | Node a (LinkedList a)
    deriving Show

-- Insert at the front of the list
insertFront :: a -> LinkedList a -> LinkedList a
insertFront value list = Node value list

-- Print elements of the list
printList :: Show a => LinkedList a -> IO ()
printList Empty = return ()
printList (Node x next) = do
    print x
    printList next

-- Example usage
main :: IO ()
main = do
    let list = Empty
    let list1 = insertFront 3 list
    let list2 = insertFront 2 list1
    let list3 = insertFront 1 list2

    putStrLn "Linked List Elements:"
    printList list3import java.util.LinkedList;

class SimpleHashMap<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    public SimpleHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // update existing
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();

        map.put("Alice", 25);
        map.put("Bob", 30);

        System.out.println("Alice age: " + map.get("Alice"));
        System.out.println("Bob age: " + map.get("Bob"));

        map.remove("Alice");
        System.out.println("Alice after removal: " + map.get("Alice"));
    }
}
