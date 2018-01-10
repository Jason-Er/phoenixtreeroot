package com.phoenixtreeroot.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.phoenixtreeroot.model.script.WriterLine;
import com.phoenixtreeroot.model.script.LineType;
import com.phoenixtreeroot.model.script.WriterPlay;
import com.phoenixtreeroot.model.script.WriterScene;
import com.phoenixtreeroot.model.system.Role;
import com.phoenixtreeroot.model.system.RoleType;
import com.phoenixtreeroot.model.system.User;
import com.phoenixtreeroot.service.PlayService;
import com.phoenixtreeroot.service.RoleService;
import com.phoenixtreeroot.service.UserService;

@Component
public class DataInitialization implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	PlayService playService;	

	@Override
	public void run(String... arg0) throws Exception {
		
		
		roleService.saveRole(new Role(RoleType.ACTOR.name()));		
		roleService.saveRole(new Role(RoleType.ADMIN.name()));		
		roleService.saveRole(new Role(RoleType.AUDIENCE.name()));		
		roleService.saveRole(new Role(RoleType.DIRECTOR.name()));
		roleService.saveRole(new Role(RoleType.SCREENWRITER.name()));
		
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
