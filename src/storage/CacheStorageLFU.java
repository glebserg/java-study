package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CacheStorageLFU extends CacheStorage {

    private final Map<String, Integer> counters = new HashMap<>();

    public CacheStorageLFU(int storageSize) {
        super(storageSize);
    }

    public CacheStorageLFU(int storageSize,boolean syncFile) {
        super(storageSize,syncFile);
    }

    @Override
    public String get(String key) {
        String result = super.data.get(key);
        if (result != null) {
            this.counters.put(key, this.counters.get(key) + 1);
        }
        return result;
    }

    @Override
    public void create(String key, String value) {
        this.counters.put(key, 0);
        super.create(key, value);
    }

    @Override
    public void remove(String key) {
        this.counters.remove(key);
        super.remove(key);
    }

    @Override
    protected void overflow() {
        ArrayList<String> allCandidates = new ArrayList<>(this.counters.keySet());
        String candidate = allCandidates.getFirst();
        int minValue = this.counters.get(candidate);
        for (int i = 1; i < allCandidates.size(); i++) {
            String newCandidateKey = allCandidates.get(i);
            int newCandidateCounter = this.counters.get(allCandidates.get(i));
            if (newCandidateCounter < minValue) {
                candidate = newCandidateKey;
                minValue = this.counters.get(newCandidateKey);
            }
        }
        this.remove(candidate);
    }

    @Override
    public void clear() {
        this.counters.clear();
        super.clear();
    }

    @Override
    public String toString() {
        return super.toString() + "\ncounters: " + this.counters.toString();
    }
}
