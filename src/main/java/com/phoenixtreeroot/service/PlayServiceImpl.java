package com.phoenixtreeroot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoenixtreeroot.model.script.WriterPlay;
import com.phoenixtreeroot.repository.PlayRepository;

@Service("playService")
@Transactional
public class PlayServiceImpl implements PlayService {

	@Autowired
	private PlayRepository repository;

	@Override
	public WriterPlay findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void savePlay(WriterPlay play) {
		repository.save(play);
	}

	@Override
	public void deletePlayById(Long id) {
		repository.delete(id);
	}

	@Override
	public void deleteAllPlays() {
		repository.deleteAll();
	}

	@Override
	public List<WriterPlay> findAllPlays() {
		return repository.findAll();
	}

	@Override
	public Page<WriterPlay> findByPage(Pageable var1) {
		return repository.findAll(var1);
	}

	@Override
	public boolean isPlayExist(WriterPlay play) {
		// TODO Auto-generated method stub
		return false;
	}

}
