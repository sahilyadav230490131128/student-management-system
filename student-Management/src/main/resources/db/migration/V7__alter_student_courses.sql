ALTER TABLE `student_management`.`students`
ADD COLUMN `dept_id` INT NOT NULL AFTER `age`;

ALTER TABLE `student_management`.`students`
ADD CONSTRAINT `std_dep_id`
  FOREIGN KEY (`dept_id`)
  REFERENCES `student_management`.`department` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `student_management`.`courses`
ADD COLUMN `dept_id` INT NOT NULL AFTER `duration`,
ADD COLUMN `instructor_id` BIGINT NOT NULL AFTER `dept_id`;

ALTER TABLE `student_management`.`courses`
ADD CONSTRAINT `fk_dept_id`
  FOREIGN KEY (`dept_id`)
  REFERENCES `student_management`.`department` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_instructor_id`
  FOREIGN KEY (`instructor_id`)
  REFERENCES `student_management`.`instructors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
