create table roles (
  id smallserial primary key ,
  role_name varchar(16)
);

create table user_account (
  id varchar(8) primary key ,
  last_name varchar(32),
  first_name varchar(32),
  grade varchar(2),
  role_id smallint,
  foreign key (role_id) references roles (id)
);

create table user_pass (
  user_id varchar(8),
  password varchar(128),
  foreign key (user_id) references user_account(id),
  primary key (user_id,password)
);

create table department (
  id smallserial primary key ,
  dp_name varchar(32)
);

create table belong_department (
  user_id varchar(8),
  department_id smallint,
  foreign key (user_id) references user_account (id),
  foreign key (department_id) references department (id),
  primary key (user_id,department_id)
);

create table message (
  id bigserial primary key ,
  title varchar(64),
  contents varchar(2048),
  deadline timestamp,
  update_date timestamp,
  user_id varchar(8),
  foreign key (user_id) references user_account(id)
);

create table already_read (
  user_id varchar(8),
  message_id bigint,
  foreign key (user_id) references user_account (id),
  foreign key (message_id) references message (id),
  primary key (user_id,message_id)
);

create table deleted_message (
  message_id bigint unique ,
  foreign key (message_id) references message (id)
);

create table message_target (
  user_id varchar(8),
  message_id bigint,
  read_unread boolean not null ,
  foreign key (user_id) references user_account (id),
  foreign key (message_id) references message (id),
  primary key (user_id,message_id)
);
