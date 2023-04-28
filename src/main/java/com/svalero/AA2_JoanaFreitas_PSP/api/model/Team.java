package com.svalero.AA2_JoanaFreitas_PSP.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    int id;
    String abbreviation;
    String city;
    String conference;
    String division;
    String fullName;
    String name;
}
