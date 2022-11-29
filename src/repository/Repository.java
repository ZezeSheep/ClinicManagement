package repository;

import java.util.List;

public abstract class Repository<T> {
    private String fileName;

    public Repository(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public abstract List<T> getAll();
    
    public abstract void save(T objT);

}
