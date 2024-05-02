package com.bemal.prescription_app.Repository;

import com.bemal.prescription_app.Entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long>, QuerydslPredicateExecutor<Route> {
}
