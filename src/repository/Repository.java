package repository;

import java.util.List;

public abstract class Repository<T> {
    protected String fileName;

    public Repository(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public abstract List<T> getAll();
    

    public abstract void save(T objT);
    
    public void modify(String id, T objT) {
        
    };

}
