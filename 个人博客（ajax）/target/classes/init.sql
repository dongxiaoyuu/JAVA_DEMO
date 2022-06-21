drop database if exists blog_java44;
create database blog_java44 character set utf8mb4;
use blog_java44;

create table user(
    id int primary key auto_increment,
    username varchar(20) not null unique,
    password varchar(256) not null,
    nickname varchar(20),
    head varchar(20),
    github varchar(256)
)comment '用户表';

create table article(
    id int primary key auto_increment,
    title varchar(256) not null,
    content mediumtext not null,
    create_time datetime default now(),
    user_id int,
    foreign key(user_id) references user(id)

)comment '文章表';

insert into user values(null,'bit','123','little','img/logo2.jpg','http://xxx.github');
insert into article (title,content,user_id) values('爱晚亭','fhoehfoohfoe',1);
insert into article (title,content,user_id) values('爱晚亭2','fhoehfoohfoe',1);
insert into article (title,content,user_id) values('爱晚亭3','fhoehfoohfoe',1);

