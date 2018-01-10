package com.phoenixtreeroot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.phoenixtreeroot.model.label.View;
import com.phoenixtreeroot.model.script.WriterPlay;
import com.phoenixtreeroot.model.script.DirectorPlay;
import com.phoenixtreeroot.model.system.Role;
import com.phoenixtreeroot.model.system.RoleType;
import com.phoenixtreeroot.model.system.User;
import com.phoenixtreeroot.service.PlayService;
import com.phoenixtreeroot.service.RoleService;
import com.phoenixtreeroot.service.StagePlayService;
import com.phoenixtreeroot.service.UserService;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/v1/method")
public class MethodController {

	public static final Logger logger = LoggerFactory.getLogger(MethodController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	PlayService playService;
	
	@Autowired
	StagePlayService stagePlayService;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value = "/play", method = RequestMethod.GET)    
	public ResponseEntity<List<WriterPlay>> listAllPlays() {
		List<WriterPlay> plays = playService.findAllPlays();
		if (plays.isEmpty()) {
			logger.info("has not plays!");			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<WriterPlay>>(plays, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/play/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPlay(@PathVariable("id") long id) {
		logger.info("Fetching Play with id {}", id);
		WriterPlay play = playService.findById(id);
		if (play == null) {
			logger.error("Play with id {} not found.", id);
			ResponseEntity.noContent();
			return new ResponseEntity("Play with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<WriterPlay>(play, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/play/", method = RequestMethod.POST)
	public ResponseEntity<?> createPlay(@RequestBody WriterPlay play, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Play : {}", play);

		playService.savePlay(play);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/model/v1/play/{id}").buildAndExpand(play.id).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

    @RequestMapping(value = "/play/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePlay(@PathVariable("id") long id, @RequestBody WriterPlay play) {
		logger.info("Updating Play with id {}", id);

		WriterPlay currentPlay = playService.findById(id);

		if (currentPlay == null) {
			logger.error("Unable to update. Play with id {} not found.", id);
			return new ResponseEntity("Unable to upate. Play with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		currentPlay = play;

		playService.savePlay(currentPlay);
		return new ResponseEntity<WriterPlay>(currentPlay, HttpStatus.OK);
	}
    
    // for stage play
    @RequestMapping(value = "/stageplay", method = RequestMethod.GET)    
	public ResponseEntity<List<DirectorPlay>> listAllStagePlays() {
		List<DirectorPlay> plays = stagePlayService.findAllStagePlays();
		if (plays.isEmpty()) {
			logger.info("has not stagePlays!");			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DirectorPlay>>(plays, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/stageplay/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getStagePlay(@PathVariable("id") long id) {
		logger.info("Fetching Play with id {}", id);
		DirectorPlay play = stagePlayService.findById(id);
		if (play == null) {
			logger.error("Play with id {} not found.", id);
			ResponseEntity.noContent();
			return new ResponseEntity("StagePlay with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DirectorPlay>(play, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/stageplay/", method = RequestMethod.POST)
	public ResponseEntity<?> createStagePlay(@RequestBody DirectorPlay play, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Play : {}", play);

		stagePlayService.saveStagePlay(play);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/model/v1/play/{id}").buildAndExpand(play.id).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
    
    @RequestMapping(value = "/stageplay/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStagePlay(@PathVariable("id") long id, @RequestBody DirectorPlay play) {
		logger.info("Updating Play with id {}", id);

		DirectorPlay currentPlay = stagePlayService.findById(id);

		if (currentPlay == null) {
			logger.error("Unable to update. Play with id {} not found.", id);
			return new ResponseEntity("Unable to upate. Play with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		currentPlay = play;

		stagePlayService.saveStagePlay(currentPlay);
		return new ResponseEntity<DirectorPlay>(currentPlay, HttpStatus.OK);
	}
    
    // for stage playInfo
    @RequestMapping(value = "/stageplayinfo", method = RequestMethod.GET)
    @JsonView(View.StagePlayInfo.class)
    public Page<DirectorPlay> getPlaysInfo(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) 
    Pageable pageable) {
	    return stagePlayService.findByPage(pageable);
	}   
    
    // for user
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User " + user.firstName);

		final User registered = userService.registerNewUserAccount(user);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/vi/method/user/{id}").buildAndExpand(user.id).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
    
}
