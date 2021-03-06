package com.phoenixtreeroot.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.phoenixtreeroot.model.Line;
import com.phoenixtreeroot.model.LineType;
import com.phoenixtreeroot.model.Play;
import com.phoenixtreeroot.model.Role;
import com.phoenixtreeroot.model.Scene;
import com.phoenixtreeroot.model.User;
import com.phoenixtreeroot.service.PlayService;
import com.phoenixtreeroot.service.UserService;

@Component
public class DataInitialization implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	@Autowired
	PlayService playService;

	@Override
	public void run(String... arg0) throws Exception {
		/*
		User user = new User();
		user.email = "mike@163.com";
		user.password = "123";
		user.firstName = "mike";
		user.lastName = "fighter";
		userService.saveUser(user);		
		
		List<Role> cast = new ArrayList<>();
		Role role = new Role();
		role.firstName = "Jill";
		role.lastName = "Bradleyson";
		role.description = "A woman in her late 20s";
		
		cast.add(role);
		
		List<Line> lines = new ArrayList<>();
		Line line = new Line();
		line.role = role;
		line.type = LineType.DIRECTION_DIALOGUE;
		line.dialogue = "What’s happening here?";
		line.stageDirection = "Two sets of footsteps";
		lines.add(line);
		
		Scene scene1 = new Scene();
		scene1.actOrdinal = 1L;
		scene1.ordinal = 1L;
		scene1.setting = "We are in the basement";
		scene1.atrise = "DONALD BRADLEYSON is curled up";
		scene1.lines = lines;
		
		line.scene = scene1;
		
		List<Scene> scenes = new ArrayList<>();
		scenes.add(scene1);
		
		Play play = new Play();
		play.name = "THE BOYS IN THE CAGE";
		play.playwright = user;
		play.cast = cast;
		play.scenes = scenes;		
		
		role.play = play;
		scene1.play = play;
		
		playService.savePlay(play);
		
		User user = userService.findByEmail("mike@163.com");
		
		System.out.println(user.toString());
		*/
	}

}
