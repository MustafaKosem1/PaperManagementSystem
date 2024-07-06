CREATE DATABASE conference_mng_db;

CREATE TABLE `role` (
	`name` varchar(45) NOT NULL,
	PRIMARY KEY (`name`)
);

CREATE TABLE `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(45) NOT NULL,
	`surname` varchar(45) NOT NULL,
	`phone` varchar(25) NOT NULL,
	`age` INT,
	`mail` varchar(45) NOT NULL,
	`password` char(80) NOT NULL,
	`enabled` tinyint NOT NULL,
	`is_reviewer_enable_to_review` tinyint NOT NULL,
    `is_reviewer_has_not_assignment` tinyint NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE
);

CREATE TABLE `users_roles`(
	`user_id` INT(11) NOT NULL,
    `role_name` varchar(45) NOT NULL,
    PRIMARY KEY (`user_id`,`role_name`),
    CONSTRAINT `user_id_fk_constraint` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `role_name_fk_constraint` FOREIGN KEY (`role_name`) REFERENCES `role` (`name`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `profession`(
	`name` varchar(45) NOT NULL,
	PRIMARY KEY (`name`)
);

CREATE TABLE `users_professions`(
	`user_id` INT(11) NOT NULL,
    `profession_name` varchar(45) NOT NULL,
    PRIMARY KEY (`user_id`,`profession_name`),
    CONSTRAINT `user_id_preofession_fk_constraint` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `profession_name_fk_constraint` FOREIGN KEY (`profession_name`) REFERENCES `profession` (`name`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `paper`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `upload_date` Date NOT NULL,
    `title` char(80) NOT NULL,
    `state` varchar(45) NOT NULL,
    `field` char(80) NOT NULL,
    `summary` LONGTEXT NOT NULL,
    `author_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
    CONSTRAINT `author_id_fk_constraint` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `paper_keyword`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `paper_id` INT NOT NULL,
    `keyword` varchar(45) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `paper_id_keyword_fk_constraint` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `paper_source`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `paper_id` INT NOT NULL,
    `source` LONGTEXT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `paper_id_source_fk_constraint` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
);

  CREATE TABLE `paper_file` (
	  `id` INT NOT NULL AUTO_INCREMENT,
	  `paper_id` INT NOT NULL,
	  `file_location` LONGTEXT NOT NULL,
	  PRIMARY KEY (`id`),
	  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
	  CONSTRAINT `paper_id_file_fk_constraint` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`id`)
	  ON DELETE NO ACTION ON UPDATE NO ACTION
  );

  CREATE TABLE `paper_assignment`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `paper_id` INT NOT NULL,
    `reviewer_id` INT NOT NULL,
    `assignment_date` DATE NOT NULL,
    `score` INT,
    `result` varchar(45),
    `state` varchar(45) NOT NULL,
    `return_date` DATE,
    `feedback` LONGTEXT,
    PRIMARY KEY (`id`),
    CONSTRAINT `paper_id_assignment_fk_constraint` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `reviewer_id_fk_constraint` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
  );
