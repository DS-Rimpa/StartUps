package com.shredder.studentws.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotEmpty(message = "{validation.name.NotEmpty}")
    @Size(min=2,max=50,message = "{validation.name.Size}")
    private String name;

    @NotNull(message = "{validation.std.NotNull}")
    @Positive(message = "{validation.std.Positive}")
    @Size(min=1,max = 12,message = "{validation.std.Minimum}")
    private Integer std;

    @NotNull(message = "{validation.std.NotNull}")
    private String dob;

}
