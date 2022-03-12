package com.repository;

import com.model.Writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface WriterRepository extends GenericRepository<Writer, Long> {
    @Override
    void create (Writer writer) throws IOException;

    @Override
    void update (Writer writer, Long aLong);

    @Override
    List<Writer> getAll () throws FileNotFoundException;

    @Override
    void delete (Writer writer, Long aLong);
}
