package com.shredder.studentws.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentUpdateRequest {


        private String name;
        private Integer std;
        private String dob;


}
