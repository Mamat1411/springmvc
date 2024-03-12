package com.pembekalanjava.v2.categories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pembekalanjava.v2.categories.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    // Hibernate Query
    // @Query(value = "select c from Category as c where id=:id")
    // Category getCategoryById(@Param("id") Long id);

    //Native SQL Query
    @Query(value = "select * from categories where id=?1", nativeQuery = true)
    Category getCategoryById(Long id);
}
