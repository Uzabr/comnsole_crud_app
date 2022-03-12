package com.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.PostStatus;
import com.model.Writer;

import java.io.*;
import java.util.*;

public class JsonWriterRepositoryImpl implements WriterRepository{
    private final Gson gson = new Gson();
    @Override
    public void create (Writer writer)  {
        try {
            Writer[] writers = gson.fromJson("writer.json", Writer[].class);
            List<Writer> writerList = Arrays.asList(writers);
            if (writerList.contains(writer)) {
        System.out.println("Пользователь уже существует");
            }
            else  {
                writerList.add(writer);
                gson.toJson(writerList, new FileWriter("writer.json"));
        }
        } catch (Exception e) {
      e.printStackTrace();
        }

    }

    @Override
    public void update (Writer writer, Long aLong)  {
        try {
        Writer[] writers = gson.fromJson(new FileReader("writer.json"), Writer[].class);
        List<Writer> writerList = Arrays.asList(writers);
        Optional<Writer> writerOp = writerList.stream()
              .filter(var -> Objects.equals(var.getId(), aLong))
              .findFirst();
        if (writerOp.isEmpty()) {
        System.out.println("Пользователь с таким ID уже существует");
        }
        else {
        Writer writerOne = writerOp.get();
        writerList.remove(writerOne);
        writerList.add(writer);
        try {
            gson.toJson(writerList, new FileWriter("writer.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        } catch (Exception e) {
        }
    }

    @Override
    public List<Writer> getAll () throws FileNotFoundException {
        Writer[] writers = gson.fromJson(new FileReader("writer.json"), Writer[].class);
        return Arrays.asList(writers);
    }

    @Override
    public void delete (Writer writer, Long aLong) {
        try {
            List<Writer> writerList = getAll();
        Optional<Writer> writerOptional = writerList.stream()
                .filter(var -> Objects.equals(var.getId(), aLong))
                .findFirst();
        if (writerOptional.isEmpty()) {
        System.out.println("Пользователь с такой ID не существует");
        }
        else {
             writerList.remove(writer);
        System.out.println("Пользователь удален ");
        }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
