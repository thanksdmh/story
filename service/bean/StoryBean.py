
from sqlalchemy import Table, MetaData, Column, Integer, String, ForeignKey, DATETIME, create_engine

stoy = Table('story', MetaData(),
             Column('sid', String(36), primary_key=True),
             Column('uid', String(36)),
             Column('story_context', String(2000)),
             Column('content_type', Integer),
             Column('create_time', DATETIME),
             Column('time', Integer),
             Column('love', Integer)
             )


class Story(object):
    def __int__(self, sid, uid, context, contentType, create_time, time, love):
        self.sid = sid
        self.uid = uid
        self.story_context = context
        self.content_type = contentType,
        self.create_time = create_time,
        self.time = time
        self.love = love