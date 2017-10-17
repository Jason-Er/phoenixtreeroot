package com.phoenixtreeroot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.phoenixtreeroot.model.Play;
import com.phoenixtreeroot.model.StagePlay;
import com.phoenixtreeroot.model.User;
import com.phoenixtreeroot.service.PlayService;
import com.phoenixtreeroot.service.StagePlayService;
import com.phoenixtreeroot.service.UserService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/v1/web")
public class WebController {

	public static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	PlayService playService;
	
	@Autowired
	StagePlayService stagePlayService;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value = "/play/", method = RequestMethod.GET)
	public ResponseEntity<List<Play>> listAllPlays() {
		List<Play> plays = playService.findAllPlays();
		if (plays.isEmpty()) {
			logger.info("has not plays!");			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Play>>(plays, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/play/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPlay(@PathVariable("id") long id) {
		logger.info("Fetching Play with id {}", id);
		Play play = playService.findById(id);
		if (play == null) {
			logger.error("Play with id {} not found.", id);
			ResponseEntity.noContent();
			return new ResponseEntity("Play with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Play>(play, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/play/", method = RequestMethod.POST)
	public ResponseEntity<?> createPlay(@RequestBody Play play, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Play : {}", play);

		playService.savePlay(play);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/model/v1/play/{id}").buildAndExpand(play.id).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

    @RequestMapping(value = "/play/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePlay(@PathVariable("id") long id, @RequestBody Play play) {
		logger.info("Updating Play with id {}", id);

		Play currentPlay = playService.findById(id);

		if (currentPlay == null) {
			logger.error("Unable to update. Play with id {} not found.", id);
			return new ResponseEntity("Unable to upate. Play with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		currentPlay = play;

		playService.savePlay(currentPlay);
		return new ResponseEntity<Play>(currentPlay, HttpStatus.OK);
	}
    
    // for stage play
    @RequestMapping(value = "/stageplay/", method = RequestMethod.GET)
	public ResponseEntity<List<StagePlay>> listAllStagePlays() {
		List<StagePlay> plays = stagePlayService.findAllStagePlays();
		if (plays.isEmpty()) {
			logger.info("has not stagePlays!");			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<StagePlay>>(plays, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/stageplay/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getStagePlay(@PathVariable("id") long id) {
		logger.info("Fetching Play with id {}", id);
		StagePlay play = stagePlayService.findById(id);
		if (play == null) {
			logger.error("Play with id {} not found.", id);
			ResponseEntity.noContent();
			return new ResponseEntity("StagePlay with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StagePlay>(play, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/stageplay/", method = RequestMethod.POST)
	public ResponseEntity<?> createStagePlay(@RequestBody StagePlay play, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Play : {}", play);

		stagePlayService.saveStagePlay(play);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/model/v1/play/{id}").buildAndExpand(play.id).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
    
    @RequestMapping(value = "/stageplay/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStagePlay(@PathVariable("id") long id, @RequestBody StagePlay play) {
		logger.info("Updating Play with id {}", id);

		StagePlay currentPlay = stagePlayService.findById(id);

		if (currentPlay == null) {
			logger.error("Unable to update. Play with id {} not found.", id);
			return new ResponseEntity("Unable to upate. Play with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		currentPlay = play;

		stagePlayService.saveStagePlay(currentPlay);
		return new ResponseEntity<StagePlay>(currentPlay, HttpStatus.OK);
	}
}
