import datetime
import uuid

from sqlalchemy import Table, MetaData, Column, Integer, String, ForeignKey, DATETIME, create_engine
from sqlalchemy.orm import mapper, sessionmaker

metadata = MetaData()

author = Table('author', metadata,
               Column('uid', String(32), primary_key=True),
               Column('name', String(50)),
               Column('works', Integer),
               Column('follow', Integer),
               Column('time', DATETIME),
               Column('opid', String(50)),
               Column('header', String(1000)),
               Column('pwd', String(100)),
               Column('email', String(100)),
               Column('phone', String(15))
               )


class Author(object):
    def __init__(self, uid, name, works, follow, time, opid, header, pwd, email, phone):
        self.name = name
        self.uid = uid
        self.pwd = pwd
        self.works = works
        self.follow = follow
        self.time = time
        self.opid = opid
        self.header = header
        self.pwd = pwd
        self.email = email
        self.phone = phone

    @classmethod
    def instance(cls, uid, name, pwd):
        return cls(uid=uid,
                   name=name,
                   works=0,
                   follow=0,
                   time=datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
                   opid='',
                   header='',
                   pwd=pwd,
                   email='',
                   phone='')  # 生成你要创建的数据对象


# create table story
# (
#    sid                  varchar(36) not null,
#    uid                  varchar(36),
#    context              varchar(2000),
#    contentType          int comment '类型：1 幽默 2 冷笑话 3 故事 4 散文 ',
#    create_time          datetime,
#    time                 int,
#    love                 int,
#    primary key (sid)
# );
stoy = Table('story', metadata,
             Column('sid', String(36), primary_key=True),
             Column('uid', String(36)),
             Column('story_context', String(2000)),
             Column('contentType', Integer),
             Column('create_time', DATETIME),
             Column('time', Integer),
             Column('love', Integer)
             )


class Story(object):
    def __int__(self, sid, uid, context, contentType, create_time, time, love):
        self.sid = sid
        self.uid = uid
        self.story_context = context
        self.contentType = contentType,
        self.create_time = create_time,
        self.time = time
        self.love = love


mapper(Author, author)
mapper(Story, stoy)

# # 创建与数据库的会话session class ,注意,这里返回给session的是个class,不是实例
# Session_class = sessionmaker(bind=engine)  # 实例和engine绑定
# Session = Session_class()  # 生成session实例，相当于游标

# mAuthor = Author(uid=str(uuid.uuid1()),
#                  name="dmh",
#                  works=0,
#                  follow=0,
#                  time=datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
#                  opid='',
#                  header='',
#                  pwd='123456',
#                  email='',
#                  phone='')  # 生成你要创建的数据对象

# mAuthor = Author.instance(str(uuid.uuid1()), 'test', '111111')
#
# print(mAuthor.name, mAuthor.uid)  # 此时还没创建对象呢，不信你打印一下id发现还是None
#
# Session.add(mAuthor)  # 把要创建的数据对象添加到这个session里， 一会统一创建
# print(mAuthor.name, mAuthor.uid)  # 此时也依然还没创建
#
# Session.commit()  # 现此才统一提交，创建数据
