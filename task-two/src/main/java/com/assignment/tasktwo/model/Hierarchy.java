package com.assignment.tasktwo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hierarchy {
    private String name;
    private List<Hierarchy> subClasses;

    public Hierarchy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", subClasses=" + subClasses +
                '}';
    }
}
