ALTER TABLE `student_management`.`enrollment`
DROP FOREIGN KEY `student_id`;
ALTER TABLE `student_management`.`enrollment`
DROP INDEX `student_id_UNIQUE` ;
;

ALTER TABLE `student_management`.`students`
CHANGE COLUMN `id` `id` BIGINT NOT NULL AUTO_INCREMENT ;

ALTER TABLE `student_management`.`enrollment`
ADD INDEX `student_id_idx` (`student_id` ASC) VISIBLE;
;
ALTER TABLE `student_management`.`enrollment`
ADD CONSTRAINT `student_id`
  FOREIGN KEY (`student_id`)
  REFERENCES `student_management`.`students` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;