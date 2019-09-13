package me.minkuk.springapp.ToDoItem;

import me.minkuk.springapp.ApiResponse.ApiResponse;
import lombok.Builder;
import java.util.List;

public class ToDoItemResponse extends ApiResponse<ToDoItem> {

    @Builder
    public ToDoItemResponse(final ToDoItem toDoItem, final List<String> errors)
    {
        super(toDoItem);
        this.setErrors(errors);
    }
}
