CREATE TABLE `student_management`.`result` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `semester` INT NOT NULL,
  `SGPA` DOUBLE NULL,
  `CGPA` DOUBLE NULL,
  `backlog` INT NOT NULL,
  `student_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `student_id_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `res_student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `student_management`.`students` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `student_management`.`payments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` BIGINT NOT NULL,
  `semester` INT NOT NULL,
  `total_amount` BIGINT NOT NULL,
  `paid_amount` BIGINT NULL,
  `payment_date` DATE NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `paument_student_id_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `paument_student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `student_management`.`students` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `student_management`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

CREATE TABLE `student_management`.`instructors` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `department_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `instructor_depart_id_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `instructor_depart_id`
    FOREIGN KEY (`department_id`)
    REFERENCES `student_management`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
