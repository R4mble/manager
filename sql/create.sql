CREATE DATABASE IF NOT EXISTS voca DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;

use voca;

drop table if exists `voca`;

create table `voca` (
    `id` bigint(20) primary key auto_increment,
    `user_id` bigint(20) not null,
    `content` varchar(100) not null,
    `chinese` varchar(100) not null,
    `pronounce` varchar(200),
    `phonetic` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    `sentence` varchar(200),
    `create_time` datetime(0) default CURRENT_TIMESTAMP
) ENGINE=InnoDB CHARACTER set utf8mb4 COLLATE = utf8mb4_unicode_ci;

create table `voca_library` (
    `id` bigint(20) primary key auto_increment,
    `content` varchar(100) not null,
    `phonetic` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    `chinese` varchar(100) not null,
    `pronounce` varchar(200),
    `sentence` varchar(200)
);

ALTER TABLE voca ADD UNIQUE KEY(user_id, content);

create table `user` (
    `id` bigint(20) primary key auto_increment,
    `name` bigint(20) not null,
    `password` varchar(100) not null,
    `avatar` varchar(200),
    `gender` int(11),
    `description` varchar(200),
    `create_time` datetime(0) default CURRENT_TIMESTAMP
)