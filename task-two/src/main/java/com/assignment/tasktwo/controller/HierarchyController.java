package com.assignment.tasktwo.controller;

import com.assignment.tasktwo.aspects.LogMethodParam;
import com.assignment.tasktwo.exception.RelationDataNotException;
import com.assignment.tasktwo.model.Hierarchy;
import com.assignment.tasktwo.model.ParentChildRelation;
import com.assignment.tasktwo.repository.ReleationshipRepository;
import com.assignment.tasktwo.util.HierarchyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping
public class HierarchyController {

    @Autowired
    private ReleationshipRepository repository;

    @GetMapping
    public List<Hierarchy> getHierarchy(){
        List<ParentChildRelation> allRelations = repository.findAll();
        return HierarchyBuilder.buildHierarchy(allRelations);
    }

    @GetMapping(
            path = "/{id}"
    )
    @LogMethodParam
    public ParentChildRelation getRelationById(@PathVariable int id){
        Optional<ParentChildRelation> relation = repository.findById(id);
        if(relation.isEmpty()){
            throw new RelationDataNotException("Relation with given id not found");
        }
        else{
            return relation.get();
        }
    }


}
