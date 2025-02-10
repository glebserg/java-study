import storage.CacheStorage;
import storage.CacheStorageLFU;

public class Main {
    public static void main(String[] args) {
        CacheStorage storage = new CacheStorageLFU(10,true);
        storage.create("key_1", "value");
        storage.create("key_2", "value");
        storage.create("key_3", "value");
        storage.create("key_4", "value");
        storage.create("key_5", "value");
        storage.create("key_6", "value");
        storage.create("key_7", "value");
        storage.create("key_8", "value");
        storage.create("key_9", "value");
        storage.create("key_10", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_12", "value");

        storage.get("key_3");
        storage.get("key_3");
        storage.get("key_3");
        storage.get("key_3");
        storage.get("key_3");

        storage.create("key_13", "value");
        storage.create("key_14", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");
        storage.create("key_11", "value");

    }
}