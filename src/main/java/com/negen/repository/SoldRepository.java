package com.negen.repository;

import com.negen.entity.Sold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldRepository extends JpaRepository<Sold, Long> {
}
