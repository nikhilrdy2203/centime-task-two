package com.assignment.tasktwo.repository;

import com.assignment.tasktwo.model.ParentChildRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleationshipRepository extends JpaRepository<ParentChildRelation,Integer> {
}
