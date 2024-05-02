package com.bemal.prescription_app.Repository;

import com.bemal.prescription_app.Entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction,Long>, QuerydslPredicateExecutor<Direction> {
}