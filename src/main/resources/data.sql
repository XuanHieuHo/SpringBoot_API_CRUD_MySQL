INSERT IGNORE INTO `us`.`users` (`email`, `full_name`, `phone`, `created_at`, `updated_at`) 
VALUES ('xh2@gmail.com', 'Ho Xuan Hieu 2', '147852369', NOW(), NOW());

INSERT IGNORE INTO `us`.`posts` (`title`, `content`, `user`, `created_at`, `updated_at`) 
VALUES ('Hello Monday','This is my post', '1', NOW(), NOW());