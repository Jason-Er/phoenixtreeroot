package com.phoenixtreeroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenixtreeroot.model.script.WriterScene;

public interface SceneRepository extends JpaRepository<WriterScene, Long> {

}
