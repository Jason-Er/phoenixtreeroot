package com.phoenixtreeroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenixtreeroot.model.script.WriterPlay;

public interface PlayRepository extends JpaRepository<WriterPlay, Long> {

}
