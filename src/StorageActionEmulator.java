import storage.CacheStorage;

import java.util.Random;

public class StorageActionEmulator {

    protected CacheStorage storage;

    public StorageActionEmulator(CacheStorage storage){
        this.storage = storage;
    }

    public void createData(int count){
        for (int i = 1; i < count; i++) {
            this.storage.create("key_"+i, "value");
        }
    }

    public void readData(int count) {
        String[] allKeys = this.storage.getKeys();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(allKeys.length);
            String key = allKeys[randomIndex];
            this.storage.get(key);
        }
    }
}
