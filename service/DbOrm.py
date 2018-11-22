
# from sqlalchemy.orm import mapper, sessionmaker
#
# from bean.AuthorBean import name, Author
# from bean.StoryBean import stoy, Story
#
# mapper(Author, name)
# mapper(Story, stoy)

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
