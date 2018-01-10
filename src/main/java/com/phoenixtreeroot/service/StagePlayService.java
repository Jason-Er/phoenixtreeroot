package com.phoenixtreeroot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phoenixtreeroot.model.script.DirectorPlay;

public interface StagePlayService {

	DirectorPlay findById(Long id);	

	void saveStagePlay(DirectorPlay play);

	void deleteStagePlayById(Long id);

	void deleteAllStagePlays();

	List<DirectorPlay> findAllStagePlays();

	Page<DirectorPlay> findByPage(Pageable var1);

	boolean isStagePlayExist(DirectorPlay play);

}
