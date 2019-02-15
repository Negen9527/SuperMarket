package com.negen.repository;

import com.negen.entity.Cigar;
import com.negen.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CigarRepository extends JpaRepository<Cigar, Long> {

}
