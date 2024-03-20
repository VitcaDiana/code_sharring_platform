package com.springapps.csp.repository;

import com.springapps.csp.model.SharedCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharedCodeRepository extends JpaRepository<SharedCode,Long> {

    List<SharedCode> findAllBySecretOrderByCreatedDateDesc(boolean secret);

}
