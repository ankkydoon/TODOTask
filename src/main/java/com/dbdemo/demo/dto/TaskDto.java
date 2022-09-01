package com.dbdemo.demo.dto;


import com.dbdemo.demo.entity.Notes;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TaskDto {
    Long id;
    String description;
    List<Notes> notes;
    Date createdDate;
    Date modifiedDate;
}
