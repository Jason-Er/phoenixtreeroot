package com.phoenixtreeroot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phoenixtreeroot.model.script.StagePlay;

public interface StagePlayService {

	StagePlay findById(Long id);	

	void saveStagePlay(StagePlay play);

	void deleteStagePlayById(Long id);

	void deleteAllStagePlays();

	List<StagePlay> findAllStagePlays();

	Page<StagePlay> findByPage(Pageable var1);

	boolean isStagePlayExist(StagePlay play);

}
