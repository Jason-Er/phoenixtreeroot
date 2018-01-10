package com.phoenixtreeroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenixtreeroot.model.script.WriterLine;

public interface LineRepository extends JpaRepository<WriterLine, Long> {

}
