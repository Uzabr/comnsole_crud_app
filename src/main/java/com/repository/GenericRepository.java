package com.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {
    void create(T t) throws IOException;
    void update(T t, ID id);
    List<T> getAll() throws FileNotFoundException;
    void  delete(T t, ID id);
}
