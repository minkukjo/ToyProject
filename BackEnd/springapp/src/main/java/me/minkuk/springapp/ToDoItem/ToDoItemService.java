package me.minkuk.springapp.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public ToDoItem get(final String id)
    {
        return toDoItemRepository.findById(id).orElse(null);
    }

    public ToDoItem create(final ToDoItem toDoItem)
    {
        if(toDoItem == null)
        {
            throw new NullPointerException("To Do Item Cannot be null.");
        }
        return toDoItemRepository.insert(toDoItem);
    }

    public ToDoItem update(final ToDoItem toDoItem)
    {
        if(toDoItem == null)
        {
            throw new NullPointerException("To Do Item Cannot be null.");
        }
        final ToDoItem original = toDoItemRepository.findById(toDoItem.getId())
                .orElseThrow(() -> new RuntimeException("Entity Not Found"));
        original.setTitle(toDoItem.getTitle());
        original.setDone(toDoItem.isDone());
        return toDoItemRepository.save(original);
    }
    public void delete(final ToDoItem toDoItem)
    {
        if(toDoItem == null)
        {
            throw new NullPointerException("To Do Item Cannot be null.");
        }
        toDoItemRepository.deleteById(toDoItem.getId());
    }

    public List<ToDoItem> getAll() {
        return toDoItemRepository.findAll();
    }
}
