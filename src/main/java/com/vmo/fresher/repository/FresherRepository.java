package com.vmo.fresher.repository;

import com.vmo.fresher.entity.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, Long> {
}
