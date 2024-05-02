package com.bemal.prescription_app.Repository;

import com.bemal.prescription_app.Entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug,Long>, QuerydslPredicateExecutor<Drug> {
}
