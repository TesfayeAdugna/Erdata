package com.erdata.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenRepository  extends JpaRepository<Children, Long> {
    // for search
    @Query(value = "select * from Children i where i.description like %:keyword% or i.birthdate like %:keyword%", nativeQuery = true)
    List<Children> findByKeyword(@Param("keyword") String keyword);
}
