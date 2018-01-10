package com.phoenixtreeroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenixtreeroot.model.script.DirectorPlay;

public interface StagePlayRepository extends JpaRepository<DirectorPlay, Long> {

}
