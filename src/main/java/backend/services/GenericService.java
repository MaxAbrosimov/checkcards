package backend.services;

import java.util.List;
import java.util.UUID;

public interface GenericService<Type> {

    List<Type> listAll();

    Type getById(UUID id);

    Type saveOrUpdate(Type product);

    void delete(UUID id);

}
