package com.tic.reto3.repository.crudRepository;

import com.tic.reto3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}

