package com.view;

import com.model.Writer;
import com.repository.JsonWriterRepositoryImpl;
import com.repository.WriterRepository;

import java.io.IOException;
import java.util.List;

public class WriterView {
    public static  WriterRepository writerRepository;

    public WriterView(){
        writerRepository = new JsonWriterRepositoryImpl();
    }

    public static void viewWriter() throws IOException {
        List<Writer> writerList = writerRepository.getAll();
    System.out.println(writerList);
    }

    public static void  createWriter(Writer writer) throws IOException{
        writerRepository.create(writer);
    }

    public static void updateWriter(Writer writer, long id) {
        writerRepository.update(writer, id);
    }

    public static  void deleteWriter(Writer writer, long id) {
        writerRepository.delete(writer, id);
    }
}
