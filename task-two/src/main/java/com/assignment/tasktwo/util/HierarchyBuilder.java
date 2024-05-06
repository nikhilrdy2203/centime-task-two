package com.assignment.tasktwo.util;

import com.assignment.tasktwo.aspects.LogMethodParam;
import com.assignment.tasktwo.model.Hierarchy;
import com.assignment.tasktwo.model.ParentChildRelation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public class HierarchyBuilder {

	
	public static List<Hierarchy> buildHierarchy(List<ParentChildRelation> allRelations) {
        Map<Integer, List<ParentChildRelation>> parentChildMap = new HashMap<>();
        
        for (ParentChildRelation relation : allRelations) {
            int parentId = relation.getParentId();
            parentChildMap.putIfAbsent(parentId, new ArrayList<>());
            parentChildMap.get(parentId).add(relation);
        }
        
        List<Hierarchy> hierarchy = new ArrayList<>();
        for (ParentChildRelation rootRelation : allRelations) {
            if (rootRelation.getParentId() == 0) {
                Hierarchy rootHierarchy = buildHierarchyHelper(rootRelation, parentChildMap);
                hierarchy.add(rootHierarchy);
            }
        }
        
        return hierarchy;
    }
    
    private static Hierarchy buildHierarchyHelper(ParentChildRelation parentRelation, Map<Integer, List<ParentChildRelation>> parentChildMap) {
        String name = parentRelation.getName();
        List<ParentChildRelation> childrenRelations = parentChildMap.get(parentRelation.getId());
        List<Hierarchy> subClasses = new ArrayList<>();
        if (childrenRelations != null) {
            for (ParentChildRelation childRelation : childrenRelations) {
                Hierarchy childHierarchy = buildHierarchyHelper(childRelation, parentChildMap);
                subClasses.add(childHierarchy);
            }
        }
        
        return Hierarchy.builder()
                        .name(name)
                        .subClasses(subClasses)
                        .build();
    }
}
