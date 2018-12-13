from . import db, login_manager


# 用户表
class Author(db.Model):
    __tablename__ = "author"
    # id号
    uid = db.Column(db.String(32), primary_key=True)
    # 用户昵称
    name = db.Column(db.String(50))
    # 发布的作品数
    works = db.Column(db.Integer)
    # 粉丝数目
    follow = db.Column(db.Integer)
    # 注册时间
    create_time = db.Column(db.DATETIME)
    # 第三方授权id
    opid = db.Column(db.String(50))
    # 头像地址
    header = db.Column(db.String(1000))
    # 密码
    pwd = db.Column(db.String(100))
    # 邮箱
    email = db.Column(db.String(100))
    # 电话
    phone = db.Column(db.String(15))
    # storys = db.relationship('Story', backref="Author", cascade='all')


# 评论表
class Comment(db.Model):
    __tablename__ = 'comment'
    id = db.Column(db.Integer, primary_key=True)
    sid = db.Column(db.String(32), db.ForeignKey('Story.id'))
    uid = db.Column(db.String(32), db.ForeignKey('author.uid'))
    create_time = db.Column(db.DATETIME)
    detail = db.Column(db.String(1000))


# 段子表
class Story(db.Model):
    __tablename__ = "story"

    id = db.Column(db.Integer, primary_key=True)
    # 用户id
    uid = db.Column(db.String(36), db.ForeignKey('author.uid'))
    # 内容
    content = db.Column(db.TEXT)
    # 类型
    type = db.Column(db.Integer)
    # 发布日期
    create_time = db.Column(db.String)
    # 被举报次数
    report_time = db.Column(db.Integer)
    # 被点赞次数
    love = db.Column(db.Integer)
    # 状态 1 显示，0 不显示
    status = db.Column(db.Integer)
    # 图片或者视频
    img = db.Column(db.TEXT)

    author = db.relationship('Author')

    def to_json(self):
        return {
            "id": self.id,
            "uid": self.uid,
            "name": self.author.name,
            "content": self.content,
            "type": self.type,
            "img": self.img,
            "love": self.love
        }


# 好友关系表
class FriendShip(db.Model):
    __tablename__ = 'frend_ship'
    id = db.Column(db.Integer, primary_key=True)
    # 用户
    uid = db.Column(db.String(32), db.ForeignKey('author.uid'))
    # 好友ID
    fid = db.Column(db.String(32), db.ForeignKey('author.uid'))


# 图片表
class Image(db.Model):
    __tablename__ = 'image'
    id = db.Column(db.Integer, primary_key=True)
    # 故事ID
    sid = db.Column(db.Integer, db.ForeignKey('story.id'))
    path = db.Column(db.TEXT)


# 举报表
class Report(db.Model):
    __tablename__ = 'report'
    id = db.Column(db.Integer, primary_key=True)
    # 故事ID
    sid = db.Column(db.Integer, db.ForeignKey('story.id'))
    # 用户ID
    uid = db.Column(db.String(32), db.ForeignKey('author.uid'))
    # 举报时间
    create_time = db.Column(db.DATETIME)
    # 举报原因
    reason = db.Column(db.TEXT)


# 点赞记录表
class LoveRecord(db.Model):
    __tablename__ = 'love_record'
    id = db.Column(db.Integer, primary_key=True)
    # 故事id
    sid = db.Column(db.Integer, db.ForeignKey('story.id'))
    # 点赞用户ID
    uid = db.Column(db.String(32), db.ForeignKey('author.uid'))
    # 点赞时间
    create_time = db.Column(db.DATETIME)
