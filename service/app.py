import json
import threading

from cffi import lock
from flask import Flask, request
# from pandas import json
from StoryApi import StoryApi

app = Flask(__name__)
# app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:123456@127.0.0.1:3306/story'
# # mysql+pymysql://root:123456@localhost/story
# app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = True
# # 查询时会显示原始SQL语句
# app.config['SQLALCHEMY_ECHO'] = True
POST = "POST"




def check():
    return request.method == POST


# 登录验证
@app.route('/login', methods=[POST])
def login():
    if check():
        param = request.data
        user = json.loads(param)
        uid = user.get("uid")
        pwd = user.get("pwd")
        story = StoryApi()
        if story.login(uid, pwd):
            return str(1)
        else:
            return str(0)
    else:
        return str(0)


@app.route('/register', methods=[POST])
def register():
    if check():
        uid = request.form.get("uid")
        pwd = request.form.get("pwd")
        name = request.form.get("name")
        story = StoryApi()
        if story.register(uid, name, pwd):
            return str(1)
        else:
            return str(0)

    else:
        return str(0)


@app.route('/getStoryList', methods=[POST])
def getStoryList():
    if check():
        # param = request.data
        # pageInfo = json.loads(param)
        # type = pageInfo.get("type")
        # page_size = pageInfo.get("pageSize")
        # page_index = pageInfo.get("pageIndex")
        type = int(request.headers.get("type"))
        page_size = int(request.headers.get("pageSize"))
        page_index = int(request.headers.get("pageIndex"))
        story = StoryApi()
        return story.getStoyList(type, page_size, page_index)
    else:
        return "查询错误"


@app.route('/')
def hello_world():
    return 'Hello World!'

#
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
    # app.run(host='10.108.151.228', port=5000, threaded=True)
