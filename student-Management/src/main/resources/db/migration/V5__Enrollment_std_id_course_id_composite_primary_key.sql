ALTER TABLE `student_management`.`enrollment`
DROP FOREIGN KEY `course_id`;
ALTER TABLE `student_management`.`enrollment`
DROP INDEX `course_id_UNIQUE` ;
;
ALTER TABLE `student_management`.`enrollment`
DROP COLUMN `id`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`student_id`, `course_id`);
;
ALTER TABLE `student_management`.`enrollment`
ADD INDEX `course_id_idx` (`course_id` ASC) VISIBLE;
;
ALTER TABLE `student_management`.`enrollment`
ADD CONSTRAINT `course_id`
  FOREIGN KEY (`course_id`)
  REFERENCES `student_management`.`courses` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;