/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/11 ������ 17:06:05                      */
/*==============================================================*/


drop table if exists author;

drop table if exists comment;

drop table if exists frend_ship;

drop table if exists image;

drop table if exists love_record;

drop table if exists report;

drop table if exists story;

/*==============================================================*/
/* Table: author                                                */
/*==============================================================*/
create table author
(
   uid                  varchar(32) not null,
   name                 varchar(50),
   works                int,
   follow               int,
   time                 datetime,
   opid                 varchar(50) comment '��������ȨID',
   header               varchar(1000),
   pwd                  varchar(100),
   email                varchar(100),
   phone                varchar(15),
   sex                  int,
   primary key (uid)
);

alter table author comment '��������';

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   cid                  varbinary(32) not null,
   sid                  varchar(32),
   uid                  varchar(32),
   detail               varchar(1000),
   time                 datetime,
   primary key (cid)
);

alter table comment comment '���۱�';

/*==============================================================*/
/* Table: frend_ship                                            */
/*==============================================================*/
create table frend_ship
(
   fid                  varchar(32) not null,
   uid                  varchar(32),
   fuid                 varchar(32),
   primary key (fid)
);

alter table frend_ship comment '���ѹ�ϵ��';

/*==============================================================*/
/* Table: image                                                 */
/*==============================================================*/
create table image
(
   sid                  varchar(32),
   id                   varchar(32) not null,
   path                 varchar(1000),
   primary key (id)
);

alter table image comment 'ͼƬ��ַ��';

/*==============================================================*/
/* Table: love_record                                           */
/*==============================================================*/
create table love_record
(
   lid                  varchar(32) not null,
   sid                  varchar(32),
   uid                  varchar(32),
   time                 datetime,
   primary key (lid)
);

/*==============================================================*/
/* Table: report                                                */
/*==============================================================*/
create table report
(
   rid                  varchar(32) not null,
   sid                  varchar(32),
   uid                  varchar(32),
   time                 datetime,
   reson                varchar(200),
   primary key (rid)
);

alter table report comment '�ٱ���¼��';

/*==============================================================*/
/* Table: story                                                 */
/*==============================================================*/
create table story
(
   sid                  varchar(32) not null,
   uid                  varchar(32),
   story_context        varchar(2000),
   content_type         int comment '���ͣ�1 ��Ĭ 2 ��Ц�� 3 ���� 4 ɢ�� ',
   create_time          datetime,
   time                 int,
   love                 int,
   primary key (sid)
);

alter table story comment '���±�';

alter table comment add constraint FK_Reference_3 foreign key (sid)
      references story (sid) on delete restrict on update restrict;

alter table comment add constraint FK_Reference_4 foreign key (uid)
      references author (uid) on delete restrict on update restrict;

alter table frend_ship add constraint FK_Reference_5 foreign key (uid)
      references author (uid) on delete restrict on update restrict;

alter table frend_ship add constraint FK_Reference_6 foreign key (fuid)
      references author (uid) on delete restrict on update restrict;

alter table image add constraint FK_Reference_2 foreign key (sid)
      references story (sid) on delete restrict on update restrict;

alter table love_record add constraint FK_Reference_10 foreign key (uid)
      references author (uid) on delete restrict on update restrict;

alter table love_record add constraint FK_Reference_9 foreign key (sid)
      references story (sid) on delete restrict on update restrict;

alter table report add constraint FK_Reference_7 foreign key (sid)
      references story (sid) on delete restrict on update restrict;

alter table report add constraint FK_Reference_8 foreign key (uid)
      references author (uid) on delete restrict on update restrict;

alter table story add constraint FK_Reference_1 foreign key (uid)
      references author (uid) on delete restrict on update restrict;

