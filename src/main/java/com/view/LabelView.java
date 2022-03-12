package com.view;

import com.model.Label;
import com.repository.JsonLabelRepoWriterImpl;
import com.repository.LableRepository;

import java.io.IOException;

public class LabelView {

    public static LableRepository lableRepository;

    public LabelView() {
        lableRepository = new JsonLabelRepoWriterImpl();
    }

    public static void viewLabel() throws IOException {
        lableRepository.getAll();
    }

    public static void createLabel(Label label) {
        lableRepository.create(label);
    }

    public static void updateLabel(Label label, long id) {
        lableRepository.update(label, id);
    }

    public static void deleteLabel(Label label, long id) {
        lableRepository.delete(label, id);
    }
}
