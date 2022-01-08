package com.youcode.gestionemployes.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface GenericDAO<T, PK extends Serializable> {
    void create(T t);

    Optional<T> get(PK id);

    Collection<T> getAll();

    T update(T t);

    void delete(T t);
}