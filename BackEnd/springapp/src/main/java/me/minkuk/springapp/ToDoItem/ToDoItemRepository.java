package me.minkuk.springapp.ToDoItem;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoItemRepository extends MongoRepository<ToDoItem,String> {

}
