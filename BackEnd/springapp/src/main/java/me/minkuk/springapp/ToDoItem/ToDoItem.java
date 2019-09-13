package me.minkuk.springapp.ToDoItem;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ToDoItem {
    @Id
    private String id;
    private String title;
    private boolean done;
}
