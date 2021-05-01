ALTER TABLE `book` ADD COLUMN `status` VARCHAR(20) DEFAULT 'ACTIVE';
insert into book values(8, 'Deleted book', 'deleted book book', 'noname', '1909', 'ISDF-20055', null, 'DELETED');
UPDATE BOOK set user_id = 1 WHERE id = 8;