package com.phoenixtreeroot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoenixtreeroot.model.Play;
import com.phoenixtreeroot.model.StagePlay;
import com.phoenixtreeroot.repository.PlayRepository;
import com.phoenixtreeroot.repository.StagePlayRepository;

@Service("stagePlayService")
@Transactional
public class StagePlayServiceImpl implements StagePlayService {

	@Autowired
	private StagePlayRepository repository;

	@Override
	public StagePlay findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void saveStagePlay(StagePlay play) {
		repository.save(play);		
	}

	@Override
	public void deleteStagePlayById(Long id) {
		repository.delete(id);		
	}

	@Override
	public void deleteAllStagePlays() {
		repository.deleteAll();		
	}

	@Override
	public List<StagePlay> findAllStagePlays() {
		return repository.findAll();
	}

	@Override
	public Page<StagePlay> findByPage(Pageable var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStagePlayExist(StagePlay play) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
