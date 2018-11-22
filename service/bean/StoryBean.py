from sqlalchemy import Column, Integer, String, ForeignKey, DATETIME
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()


class Author(Base):
    __tablename__ = "name"
    uid = Column(String(32), primary_key=True)
    name = Column(String(50))
    works = Column(Integer)
    follow = Column(Integer)
    time = Column(DATETIME)
    opid = Column(String(50))
    header = Column(String(1000))
    pwd = Column(String(100))
    email = Column(String(100))
    phone = Column(String(15))


class Story(Base):
    __tablename__ = "story"
    sid = Column(String(36), primary_key=True)
    uid = Column(String(36), ForeignKey('name.uid'))
    story_context = Column(String(2000))
    content_type = Column(Integer)
    create_time = Column(DATETIME)
    time = Column(Integer)
    love = Column(Integer)

    def to_json(self):
        return {
            "sid": self.sid,
            "uid": self.uid,
            "name": "test",
            "story_context": self.story_context,
            "content_type": self.content_type,
            "time": self.time,
            "love": self.love,

        }


class Comment(Base):
    __tablename__ = 'comment'

    cid = Column(String(32), primary_key=True)
    sid = Column(String(32))
    uid = Column(String(32))
    time = Column(DATETIME)
    detail = Column(String(1000))


class FriendShip(Base):
    __tablename__ = 'frend_ship'

    fid = Column(String(32), primary_key=True)
    uid = Column(String(32))
    fuid = Column(String(32))


class Image(Base):
    __tablename__ = 'image'
    id = Column(String(32), primary_key=True)
    sid = Column(String(32))
    path = Column(String(32))


class Report(Base):
    __tablename__ = 'report'
    rid = Column('rid', String(32), primary_key=True)
    sid = Column('sid', String(32))
    uid = Column('uid', String(32))
    time = Column('time', DATETIME)
    reson = Column('reson', DATETIME)


class LoveRecord(Base):
    __tablename__ = 'love_record'
    lid = Column('lid', String(32), primary_key=True)
    sid = Column('sid', String(32))
    uid = Column('uid', String(32))
    time = Column('time', DATETIME)
