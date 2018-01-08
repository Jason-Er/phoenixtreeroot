package com.phoenixtreeroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenixtreeroot.model.script.Line;

public interface LineRepository extends JpaRepository<Line, Long> {

}
