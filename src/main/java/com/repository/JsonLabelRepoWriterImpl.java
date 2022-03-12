package com.repository;

import com.google.gson.Gson;
import com.model.Label;
import org.w3c.dom.html.HTMLLabelElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonLabelRepoWriterImpl implements LableRepository{
    private final Gson gson = new Gson();
    @Override
    public void create (Label label) {
            try {
                Label[] labels = gson.fromJson("label.json", Label[].class);
                List<Label> list = Arrays.asList(labels);
                for (Label label1 : labels) {
                    if (label1.equals(label)) {
                        System.out.println("Такая метка уже существует");
                    }
                    else {
                        list.add(label);
                        gson.toJson(list, new FileWriter("label.json"));
                    }
                }
            } catch (IOException e) {
      System.out.println("Ощибка  записе в файл !");
            }
    }

    @Override
    public void update (Label label, Long aLong) {
        Label[]  labels = gson.fromJson("label.json", Label[].class);
        List<Label> list = Arrays.asList(labels);
        Optional<Label> optionalLabel = list
                .stream()
                .filter(x -> Objects.equals(x.getId(), aLong))
                .findFirst();
        if (optionalLabel.isEmpty()) {
      System.out.println("Нет такой метки ");
        }
        else {
            try {
            Label l = optionalLabel.get();
            list.remove(l);
            list.add(label);
            gson.toJson(list, new FileWriter("label.json"));
            } catch (IOException e) {
          System.out.println("Ошибка записе в файл");
            }
        }
    }

    @Override
    public List<Label> getAll () {
        Label[] labels = gson.fromJson("label.json", Label[].class);
        return Arrays.asList(labels);
    }

    @Override
    public void delete (Label label, Long aLong) {
        List<Label> list = getAll();
        Optional<Label> optional = list
                .stream()
                .filter(x-> Objects.equals(x.getId(), aLong))
                .findFirst();
        if (optional.isEmpty()) {
            System.out.println("Нет такой метки ");
        }
        else {
            try {

                Label l = optional.get();
                list.remove(l);
                gson.toJson(list, new FileWriter("label.json"));
            }
            catch (IOException e) {
                System.out.println("Ошибка записе в файл");
            }
        }
    }
}
