package dev.codex.cinestar.Common.Contracts;

import java.util.List;

public interface CrudService<T, ID, Dto> {
    List<T> findAll();

    T findById(ID id);

    T create(Dto dto);

    T update(ID id, Dto dto);

    void delete(ID id);

}
