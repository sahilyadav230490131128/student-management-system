ALTER TABLE `student_management`.`students`
CHANGE COLUMN `date_of_birth` `date_of_birth` DATE NOT NULL ,
CHANGE COLUMN `status` `status` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `created_at` `created_at` TIMESTAMP NOT NULL ,
CHANGE COLUMN `updated_at` `updated_at` TIMESTAMP NOT NULL ,
CHANGE COLUMN `phone` `phone` VARCHAR(20) NOT NULL ;