package com.project.repository;

import com.project.domain.entity.BaseEntity;
import com.project.filter.Filter;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository <T extends BaseEntity, I extends Serializable>{

    List<T> getAll(Filter... filters);

    T save(T entity);

    T update(T entity);

    Optional<T> findById(I id);

    void softDelete(T entity);

    T delete(T entity);

    void restore(T entity);

}
