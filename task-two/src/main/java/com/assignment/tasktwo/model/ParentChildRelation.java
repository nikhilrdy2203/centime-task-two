package com.assignment.tasktwo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "relation"
)
public class ParentChildRelation {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int parentId;
    private String name;
    private String color;
}
