# import datetime
# import uuid
# from sqlalchemy import Table, MetaData, Column, Integer, String, ForeignKey, DATETIME, create_engine
#
# metadata = MetaData()
#
# name = Table('name', MetaData(),
#                Column('uid', String(32), primary_key=True),
#                Column('name', String(50)),
#                Column('works', Integer),
#                Column('follow', Integer),
#                Column('time', DATETIME),
#                Column('opid', String(50)),
#                Column('header', String(1000)),
#                Column('pwd', String(100)),
#                Column('email', String(100)),
#                Column('phone', String(15))
#                )
#
#
# class Author(object):
#     def __init__(self, uid, name, works, follow, time, opid, header, pwd, email, phone):
#         self.name = name
#         self.uid = uid
#         self.pwd = pwd
#         self.works = works
#         self.follow = follow
#         self.time = time
#         self.opid = opid
#         self.header = header
#         self.pwd = pwd
#         self.email = email
#         self.phone = phone
#
#     @classmethod
#     def instance(cls, uid, name, pwd):
#         return cls(uid=uid,
#                    name=name,
#                    works=0,
#                    follow=0,
#                    time=datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
#                    opid='',
#                    header='',
#                    pwd=pwd,
#                    email='',
#                    phone='')  # 生成你要创建的数据对象
