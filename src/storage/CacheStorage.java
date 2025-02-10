package storage;
import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class CacheStorage {

    protected int storageSize = 10;
    protected boolean SyncFile = true;

    protected final Map<String, String> data = new HashMap<>();

    public CacheStorage(int storageSize) {
        this.storageSize = storageSize;
    }

    public CacheStorage(int storageSize,boolean syncFile) {
        this.storageSize = storageSize;
        this.SyncFile = syncFile;
    }

    public String get(String key) {
        return this.data.get(key);
    }

    public void create(String key, String value) {
        if (this.data.size() >= this.storageSize) {
            this.overflow();
        }
        this.data.put(key, value);
        if (this.SyncFile) {
            this.syncDataToFile();
        }
    }

    protected void syncDataToFile() {
        Gson gson = new Gson();
        String json = gson.toJson(this.data);
        try (FileWriter fileWriter = new FileWriter("output.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void overflow() {
        Random generator = new Random();
        int randomIndex = generator.nextInt(storageSize - 1);
        String candidate = (String) this.data.keySet().toArray()[randomIndex];
        this.remove(candidate);
    }

    public void remove(String key) {
        if (this.data.get(key) != null) {
            this.data.remove(key);
        }
        if (this.SyncFile) {
            this.syncDataToFile();
        }
    }

    public void clear() {
        this.data.clear();
        if (this.SyncFile) {
            this.syncDataToFile();
        }
    }

    public String[] getKeys(){
        return this.data.keySet().toArray(new String[0]);
    }

    public String toString() {
        return "\nfullness: " + this.data.size() + "/" + this.storageSize + "\ndata: " + this.data.toString();
    }
}