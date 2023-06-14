package uz.pdp.BilolIncorporation.repository;

import java.util.List;
import java.util.UUID;

public interface BaseRepository<T> {
    T save(T t);
    List<T> getAll();
    T getById(UUID id);
    void deleteById(UUID id);

}
