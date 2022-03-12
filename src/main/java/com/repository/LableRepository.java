package com.repository;

import com.model.Label;

import java.util.List;

public interface LableRepository extends GenericRepository<Label,Long> {
    @Override
    void create (Label label);

    @Override
    void update (Label label, Long aLong);

    @Override
    List<Label> getAll ();

    @Override
    void delete (Label label, Long aLong);
}
