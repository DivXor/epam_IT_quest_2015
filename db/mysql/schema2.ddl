-- MySQL Script generated by MySQL Workbench
-- 12/28/15 13:45:08
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema it_quest
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `it_quest` ;

-- -----------------------------------------------------
-- Schema it_quest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `it_quest` DEFAULT CHARACTER SET utf8 ;
USE `it_quest` ;

-- -----------------------------------------------------
-- Table `it_quest`.`ASSOCIATIONS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`ASSOCIATIONS` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`ASSOCIATIONS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `IMG1` VARCHAR(100) NOT NULL,
  `IMG2` VARCHAR(100) NOT NULL,
  `IMG3` VARCHAR(100) NOT NULL,
  `IMG4` VARCHAR(100) NOT NULL,
  `HINT_TOTAL` INT NOT NULL DEFAULT 0,
  `BASE_SCORE` DECIMAL(10,2) NOT NULL DEFAULT 0,
  `HIDDEN_WORD` VARCHAR(100) NOT NULL,
  `CATEGORY` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`TASK`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`TASK` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`TASK` (
  `ID` INT NOT NULL,
  `TYPE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `it_quest`.`USERS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`USERS` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`USERS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL,
  `PASSWORD` VARCHAR(100) NULL,
  `ROLE` ENUM('ADMIN', 'ANONYMOUS', 'USER') NOT NULL,
  `TASK_ID` INT NOT NULL,
  INDEX `fk_USERS_TASK1_idx` (`TASK_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_USERS_TASK1`
  FOREIGN KEY (`TASK_ID`)
  REFERENCES `it_quest`.`TASK` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `it_quest`.`ASSOCIATIONS_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`ASSOCIATIONS_HISTORY` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`ASSOCIATIONS_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `HINT_COUNTER` INT NOT NULL DEFAULT 0,
  `TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ASSOCIATIONS_ID` INT NOT NULL,
  `USER_ID` INT NOT NULL,
  `IS_ANSWER_RIGHT` TINYINT(1) NULL DEFAULT 0,
  INDEX `ASSOCIATIONS_FK` (`ASSOCIATIONS_ID` ASC),
  INDEX `ASSOCIATIONS_HISTORY_USER_FK` (`USER_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `ASSOCIATIONS_FK`
  FOREIGN KEY (`ASSOCIATIONS_ID`)
  REFERENCES `it_quest`.`ASSOCIATIONS` (`ID`),
  CONSTRAINT `ASSOCIATIONS_HISTORY_USER_FK`
  FOREIGN KEY (`USER_ID`)
  REFERENCES `it_quest`.`USERS` (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`COMMENTS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`COMMENTS` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`COMMENTS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `MESSAGE` VARCHAR(500) NULL,
  `TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` INT NOT NULL,
  INDEX `COMMENTS_USER_FK` (`USER_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `COMMENTS_USER_FK`
  FOREIGN KEY (`USER_ID`)
  REFERENCES `it_quest`.`USERS` (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`GRAMMAR_QUIZ`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`GRAMMAR_QUIZ` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`GRAMMAR_QUIZ` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ANSWER` VARCHAR(10) NOT NULL,
  `SENTENCE` VARCHAR(1000) NOT NULL,
  `BASE_SCORE` DECIMAL(10,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`GRAMMAR_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`GRAMMAR_HISTORY` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`GRAMMAR_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `GRAMMAR_QUIZ_ID` INT NOT NULL,
  `USER_ID` INT NOT NULL,
  INDEX `GRAMMAR_HISTORY_USER_FK` (`USER_ID` ASC),
  INDEX `GRAMMAR_QUIZ_FK` (`GRAMMAR_QUIZ_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `GRAMMAR_HISTORY_USER_FK`
  FOREIGN KEY (`USER_ID`)
  REFERENCES `it_quest`.`USERS` (`ID`),
  CONSTRAINT `GRAMMAR_QUIZ_FK`
  FOREIGN KEY (`GRAMMAR_QUIZ_ID`)
  REFERENCES `it_quest`.`GRAMMAR_QUIZ` (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`MAZE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`MAZE` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`MAZE` (
  `ID` INT NOT NULL,
  `WX` INT NOT NULL,
  `WY` INT NOT NULL,
  `WORD` VARCHAR(100) NOT NULL,
  `BASE_SCORE` DECIMAL(10,2) NOT NULL DEFAULT 0,
  `PASSWORD` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`MAZE_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`MAZE_HISTORY` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`MAZE_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MAZE_ID` INT NOT NULL,
  `USER_ID` INT NOT NULL,
  INDEX `MAZE_FK` (`MAZE_ID` ASC),
  INDEX `MAZE_HISTORY_USER_FK` (`USER_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `MAZE_FK`
  FOREIGN KEY (`MAZE_ID`)
  REFERENCES `it_quest`.`MAZE` (`ID`),
  CONSTRAINT `MAZE_HISTORY_USER_FK`
  FOREIGN KEY (`USER_ID`)
  REFERENCES `it_quest`.`USERS` (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`QUEST`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`QUEST` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`QUEST` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `isDone` TINYINT(1) NULL DEFAULT 0,
  `USERS_ID` INT NOT NULL,
  `SCORE` DECIMAL(10,2) NULL,
  `TASK_ID` INT NOT NULL,
  `DONE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `fk_TASKS_USERS1_idx` (`USERS_ID` ASC),
  INDEX `fk_QUEST_TASK1_idx` (`TASK_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TASKS_USERS1`
  FOREIGN KEY (`USERS_ID`)
  REFERENCES `it_quest`.`USERS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_QUEST_TASK1`
  FOREIGN KEY (`TASK_ID`)
  REFERENCES `it_quest`.`TASK` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `it_quest`.`WORD_SEARCH`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`WORD_SEARCH` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`WORD_SEARCH` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ANSWER` VARCHAR(100) NOT NULL,
  `BASE_SCORE` DECIMAL(10,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`WORD_SEARCH_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`WORD_SEARCH_HISTORY` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`WORD_SEARCH_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `WORD_SEARCH_ID` INT NOT NULL,
  `USER_ID` INT NOT NULL,
  INDEX `WORD_SEARCH_FK` (`WORD_SEARCH_ID` ASC),
  INDEX `WORD_SEARCH_HISTORY_USER_FK` (`USER_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `WORD_SEARCH_FK`
  FOREIGN KEY (`WORD_SEARCH_ID`)
  REFERENCES `it_quest`.`WORD_SEARCH` (`ID`),
  CONSTRAINT `WORD_SEARCH_HISTORY_USER_FK`
  FOREIGN KEY (`USER_ID`)
  REFERENCES `it_quest`.`USERS` (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`EXCESS_IMAGE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`EXCESS_IMAGE` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`EXCESS_IMAGE` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `EXCESS_IMAGE_NUMBER` INT NOT NULL,
  `IMG1` VARCHAR(100) NULL,
  `IMG2` VARCHAR(100) NULL,
  `IMG3` VARCHAR(100) NULL,
  `IMG4` VARCHAR(100) NULL,
  `BASE_SCORE` DECIMAL(10,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `it_quest`.`EXCESS_IMAGE_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `it_quest`.`EXCESS_IMAGE_HISTORY` ;

CREATE TABLE IF NOT EXISTS `it_quest`.`EXCESS_IMAGE_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` INT NOT NULL,
  `EXCESS_IMAGE_ID` INT NOT NULL,
  INDEX `WRONG_PICTURE_USER_FK` (`USER_ID` ASC),
  INDEX `fk_EXCESS_IMAGE_HISTORY_EXCESS_IMAGE1_idx` (`EXCESS_IMAGE_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `WRONG_PICTURE_USER_FK`
  FOREIGN KEY (`USER_ID`)
  REFERENCES `it_quest`.`USERS` (`ID`),
  CONSTRAINT `fk_EXCESS_IMAGE_HISTORY_EXCESS_IMAGE1`
  FOREIGN KEY (`EXCESS_IMAGE_ID`)
  REFERENCES `it_quest`.`EXCESS_IMAGE` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;