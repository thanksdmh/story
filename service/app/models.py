from . import db, login_manager


class Author(db.Model):
    __tablename__ = "author"
    uid = db.Column(db.String(32), primary_key=True)
    name = db.Column(db.String(50))
    works = db.Column(db.Integer)
    follow = db.Column(db.Integer)
    time = db.Column(db.DATETIME)
    opid = db.Column(db.String(50))
    header =db. Column(db.String(1000))
    pwd = db.Column(db.String(100))
    email = db.Column(db.String(100))
    phone = db.Column(db.String(15))
    # storys = relationship('Story', backref="Author",cascade='all')


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
            "name": "dmh",
            "story_context": self.story_context,
            "content_type": self.content_type,
            "time": self.time,
            "love": self.love,

        }
