from . import db, login_manager


# 用户表
class Author(db.Model):
    __tablename__ = "author"
    uid = db.Column(db.String(32), primary_key=True)
    name = db.Column(db.String(50))
    works = db.Column(db.Integer)
    follow = db.Column(db.Integer)
    time = db.Column(db.DATETIME)
    opid = db.Column(db.String(50))
    header = db.Column(db.String(1000))
    pwd = db.Column(db.String(100))
    email = db.Column(db.String(100))
    phone = db.Column(db.String(15))
    storys = db.relationship('Story', backref="Author", cascade='all')


# 评论表
class Comment(db.Model):
    __tablename__ = 'comment'

    cid = db.Column(db.String(32), primary_key=True)
    sid = db.Column(db.String(32))
    uid = db.Column(db.String(32))
    time = db.Column(db.DATETIME)
    detail = db.Column(db.String(1000))


# 段子表
class Story(db.Model):
    __tablename__ = "story"
    sid = db.Column(db.String(36), primary_key=True)
    uid = db.Column(db.String(36), db.ForeignKey('author.uid'))
    story_context = db.Column(db.String(2000))
    content_type = db.Column(db.Integer)
    create_time = db.Column(db.DATETIME)
    time = db.Column(db.Integer)
    love = db.Column(db.Integer)

    # author = db.relationship('Author')

    def to_json(self):
        return {
            "sid": self.sid,
            "uid": self.uid,
            "name": self.Author.name,
            "story_context": self.story_context,
            "content_type": self.content_type,
            "time": self.time,
            "love": self.love,

        }


# 好友关系表
class FriendShip(db.Model):
    __tablename__ = 'frend_ship'

    fid = db.Column(db.String(32), primary_key=True)
    uid = db.Column(db.String(32))
    fuid = db.Column(db.String(32))


# 图片表
class Image(db.Model):
    __tablename__ = 'image'
    id = db.Column(db.String(32), primary_key=True)
    sid = db.Column(db.String(32))
    path = db.Column(db.String(32))


# 举报表
class Report(db.Model):
    __tablename__ = 'report'
    rid = db.Column(db.String(32), primary_key=True)
    sid = db.Column(db.String(32))
    uid = db.Column(db.String(32))
    time = db.Column(db.DATETIME)
    reson = db.Column(db.DATETIME)


# 点赞记录表
class LoveRecord(db.Model):
    __tablename__ = 'love_record'
    lid = db.Column(db.String(32), primary_key=True)
    sid = db.Column(db.String(32))
    uid = db.Column(db.String(32))
    time = db.Column(db.DATETIME)
