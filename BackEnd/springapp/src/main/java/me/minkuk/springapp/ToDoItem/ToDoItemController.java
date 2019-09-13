package me.minkuk.springapp.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoItemController {
    @Autowired
    private ToDoItemService toDoItemService;

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ToDoItemResponse get(@PathVariable(value = "id")String id)
    {
        List<String> errors = new ArrayList<>();
        ToDoItem toDoItem = null;
        try
        {
            toDoItem = toDoItemService.get(id);
        }catch (final Exception e)
        {
            errors.add(e.getMessage());
        }
        return ToDoItemAdapter.toDoItemResponse(toDoItem, errors);
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ToDoItemResponse> getAll()
    {
        List<String> errors = new ArrayList<>();
        List<ToDoItem> toDoItems = toDoItemService.getAll();
        List<ToDoItemResponse> toDoItemResponses = new ArrayList<>();
        toDoItems.stream().forEach(toDoItem -> {
            toDoItemResponses.add(ToDoItemAdapter.toDoItemResponse(toDoItem, errors));
        });
        return toDoItemResponses;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ToDoItemResponse create(@RequestBody final ToDoItemRequest toDoItemRequest)
    {
        List<String> erros = new ArrayList();
        ToDoItem toDoItem = ToDoItemAdapter.toDoItem(toDoItemRequest);
        System.out.println(toDoItemRequest.getTitle());
        try
        {
            toDoItem = toDoItemService.create(toDoItem);
        } catch (final Exception e)
        {
            erros.add(e.getMessage());
            e.printStackTrace();
        }
        return ToDoItemAdapter.toDoItemResponse(toDoItem, erros);
    }
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ToDoItemResponse update(@RequestBody final ToDoItemRequest toDoItemRequest)
    {
        List<String> erros = new ArrayList();
        ToDoItem toDoItem = ToDoItemAdapter.toDoItem(toDoItemRequest);
        System.out.println(toDoItemRequest.getTitle());
        try
        {
            toDoItemService.update(toDoItem);
        } catch (final Exception e)
        {
            erros.add(e.getMessage());
            e.printStackTrace();
        }
        return ToDoItemAdapter.toDoItemResponse(toDoItem, erros);
    }

}
