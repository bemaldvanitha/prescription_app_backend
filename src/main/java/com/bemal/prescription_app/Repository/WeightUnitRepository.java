package com.bemal.prescription_app.Repository;

import com.bemal.prescription_app.Entity.WeightUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightUnitRepository extends JpaRepository<WeightUnit,Long>, QuerydslPredicateExecutor<WeightUnit> {
}