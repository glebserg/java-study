import storage.CacheStorage;
import storage.CacheStorageLFU;

public class Main {
    public void generateCache(CacheStorage storage) {

    }
    public static void main(String[] args) {
        CacheStorage storage = new CacheStorageLFU(2,false);
        StorageActionEmulator emulator = new StorageActionEmulator(storage);

        emulator.createData(5);
        System.out.println(storage);
        emulator.readData(1000);

        System.out.println(storage);

    }
}