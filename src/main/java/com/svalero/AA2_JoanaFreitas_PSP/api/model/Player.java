package com.svalero.AA2_JoanaFreitas_PSP.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    int id;
    String first_name;
    String last_name;
    String position;
    int height_feet;
    int height_inches;
    int weight_pounds;
    List<String> team;


}
