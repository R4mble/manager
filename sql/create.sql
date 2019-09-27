drop table if exists `voca`;

create table `voca` (
    `id` bigint(20) primary key auto_increment,
    `user_id` bigint(20) not null,
    `content` varchar(100) not null,
    `pronounce` varchar(200),
    `phonetic` varchar(200),
    `sentence` varchar(200),
    `create_time` datetime(0) default CURRENT_TIMESTAMP
)

create table `user` (
    `id` bigint(20) primary key auto_increment,
    `name` bigint(20) not null,
    `password` varchar(100) not null,
    `avatar` varchar(200),
    `gender` int(11),
    `description` varchar(200),
    `create_time` datetime(0) default CURRENT_TIMESTAMP
)