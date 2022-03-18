use demo;
delimiter $$
create procedure get_user_by_id(in user_id int)
begin
	select users.name, users.email, users.country
    from users
    where users.id = user_id;
end $$
delimiter ;

delimiter $$
create procedure insert_user(
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50))
begin
	insert into users(`name`, email, country) values (user_name, user_email, user_country);
end $$
delimiter ;
