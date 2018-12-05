import uuid
from datetime import datetime

from sqlalchemy.orm import mapper, sessionmaker
from sqlalchemy import create_engine
from bean.AuthorBean import name, Author
# from bean.StoryBean import Story

mapper(Author, name)
# mapper(Story, stoy)
engine = create_engine("mysql+pymysql://root:123456@localhost:3306/story",
                           max_overflow=0,  # 超过连接池大小外最多创建的连接
                           pool_size=5,  # 连接池大小
                           pool_timeout=30,  # 池中没有线程时，最多等待的时间，超时报错，默认30秒
                           pool_recycle=-1,  # 多久之后对线程池中的线程进行一次连接的回收（重置），-1代表永远不回收，即一直被重用
                           encoding='utf-8', echo=True)
# 创建与数据库的会话session class ,注意,这里返回给session的是个class,不是实例
Session_class = sessionmaker(bind=engine)  # 实例和engine绑定
Session = Session_class()  # 生成session实例，相当于游标

mAuthor = Author(uid=str(uuid.uuid1()),
                 name="dmh",
                 works=0,
                 follow=0,
                 time=datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
                 opid='',
                 header='',
                 pwd='123456',
                 email='',
                 phone='')  # 生成你要创建的数据对象

mAuthor = Author.instance(str(uuid.uuid1()), 'test', '111111')

print(mAuthor.name, mAuthor.uid)  # 此时还没创建对象呢，不信你打印一下id发现还是None

Session.add(mAuthor)  # 把要创建的数据对象添加到这个session里， 一会统一创建
print(mAuthor.name, mAuthor.uid)  # 此时也依然还没创建

Session.commit()  # 现此才统一提交，创建数据
