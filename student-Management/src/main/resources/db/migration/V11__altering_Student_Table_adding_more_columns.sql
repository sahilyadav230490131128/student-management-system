ALTER TABLE `student_management`.`students`
ADD COLUMN `date_of_birth` DATE NULL AFTER `dept_id`,
ADD COLUMN `status` VARCHAR(45) NULL AFTER `date_of_birth`,
ADD COLUMN `created_at` TIMESTAMP NULL AFTER `status`,
ADD COLUMN `updated_at` TIMESTAMP NULL AFTER `created_at`;