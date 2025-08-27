package com.DinizAndre.Coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DinizAndre.Coffee.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
