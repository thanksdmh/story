import json
import uuid

import gc
from sqlalchemy import create_engine, and_
from sqlalchemy.orm import sessionmaker

# from DbOrm import Author, Story
from app.models import Story


class StoryApi(object):
    engine = create_engine("mysql+pymysql://root:123456@localhost/demo",
                           max_overflow=0,  # 超过连接池大小外最多创建的连接
                           pool_size=5,  # 连接池大小
                           pool_timeout=30,  # 池中没有线程时，最多等待的时间，超时报错，默认30秒
                           pool_recycle=-1,  # 多久之后对线程池中的线程进行一次连接的回收（重置），-1代表永远不回收，即一直被重用
                           encoding='utf-8', echo=True)
    Session_class = sessionmaker(bind=engine)  # 实例和engine绑定
    session = Session_class()

    def get_session(self):
        engine = create_engine("mysql+pymysql://root:123456@localhost/demo",
                               max_overflow=0,  # 超过连接池大小外最多创建的连接
                               pool_size=5,  # 连接池大小
                               pool_timeout=30,  # 池中没有线程时，最多等待的时间，超时报错，默认30秒
                               pool_recycle=-1,  # 多久之后对线程池中的线程进行一次连接的回收（重置），-1代表永远不回收，即一直被重用
                               encoding='utf-8', echo=True)
        Session_class = sessionmaker(bind=engine)  # 实例和engine绑定
        return Session_class()  # 生成session实例，相当于游标

    # # 登录
    # def login(self, uid, pwd):
    #     size = self.get_session().query(Author).filter(and_(Author.uid == uid, Author.pwd == pwd)).all()
    #     return len(size) >= 1
    #
    # # 注册
    # def register(self, uid, name, pwd):
    #     authors = self.get_session().query(Author).filter(Author.uid == uid).all()
    #     if len(authors) > 0:
    #         return False
    #     mAuthor = Author.instance(uid, name, pwd)
    #     result = self.get_session().add(mAuthor)  # 把要创建的数据对象添加到这个session里， 一会统一创建
    #
    #     self.Session.commit()  # 现此才统一提交，创建数据
    #     return True

    def getStoyList(self, content_type, pageSize, pageIndex):
        # sesion = self.session
        result = self.session.query(Story).filter(Story.type == content_type).order_by(
            Story.create_time.desc()).limit(pageSize).offset(
            (pageIndex - 1) * pageSize).all()
        # result = Story.query.filter(Story.content_type == content_type).paginate(int(pageIndex), int(pageSize),
        #                                                                          False).all()
        # result = Story.query.filter_by(Story.type == content_type).all()
        strJson = json.dumps(result, default=Story.to_json)
        # sesion.close()
        # del sesion
        # gc.collect()
        return strJson
