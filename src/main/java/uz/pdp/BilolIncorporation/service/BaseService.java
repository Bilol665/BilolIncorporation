package uz.pdp.BilolIncorporation.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {
    int add(T model);
    List<T> getAll();
    T getById(UUID id);
    void deleteById(UUID id);
}
