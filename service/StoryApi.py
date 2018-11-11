import uuid

from sqlalchemy import create_engine, and_
from sqlalchemy.orm import sessionmaker

from DbOrm import Author, Story


class StoryApi(object):
    engine = create_engine("mysql+pymysql://root:123456@localhost/story",
                           encoding='utf-8', echo=True)
    Session_class = sessionmaker(bind=engine)  # 实例和engine绑定
    Session = Session_class()  # 生成session实例，相当于游标

    # 登录
    def login(self, uid, pwd):
        size = self.Session.query(Author).filter(and_(Author.uid == uid, Author.pwd == pwd)).all()
        return len(size) >= 1

    # 注册
    def register(self, uid, name, pwd):
        authors = self.Session.query(Author).filter(Author.uid == uid).all()
        if len(authors) > 0:
            return False
        mAuthor = Author.instance(uid, name, pwd)
        result = self.Session.add(mAuthor)  # 把要创建的数据对象添加到这个session里， 一会统一创建

        self.Session.commit()  # 现此才统一提交，创建数据
        return True

    def getStoyList(self, contentType, pageSize, pageIndex):
        return self.Session.query(Story).filter(Story.contentType == contentType).order_by(
            Story.create_time.desc()).limit(pageSize).offset(
            (pageIndex - 1) * pageSize).all()
