package com.example.SampleJPAREST.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Samples
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 5 , message = "title should not be null and should contain min 5 char")
    private String title;
    @NotNull
    @Size(min = 5 , max = 30 , message = "author should not be null and contain min 5 and max 30 characters")
    private  String author;
    @NotNull
    private Integer price;
    @Email(message = "email should be in proper format")
    private String email;
}
