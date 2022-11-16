package com.vmo.fresher.repository;

import com.vmo.fresher.entity.CenterFresher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterFreshRepository extends JpaRepository<CenterFresher, Long> {

    List<CenterFresher> findAllByCenterId(Long centerId);

}
