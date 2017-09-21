package com.phoenixtreeroot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phoenixtreeroot.model.Play;

public interface PlayService {

	Play findById(Long id);	

	void savePlay(Play play);

	void deletePlayById(Long id);

	void deleteAllPlays();

	List<Play> findAllPlays();

	Page<Play> findByPage(Pageable var1);

	boolean isPlayExist(Play play);

}
