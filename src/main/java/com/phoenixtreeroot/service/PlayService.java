package com.phoenixtreeroot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phoenixtreeroot.model.script.WriterPlay;

public interface PlayService {

	WriterPlay findById(Long id);	

	void savePlay(WriterPlay play);

	void deletePlayById(Long id);

	void deleteAllPlays();

	List<WriterPlay> findAllPlays();

	Page<WriterPlay> findByPage(Pageable var1);

	boolean isPlayExist(WriterPlay play);

}
