package com.example.demo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private Long id;
    private String name;
    private Category category;
    private List<Tag> tags;
    private String status;
}
