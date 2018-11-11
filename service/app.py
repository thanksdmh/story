from flask import Flask, request
from pandas import json

from StoryApi import StoryApi

app = Flask(__name__)

POST = "POST"
story = StoryApi()


def check():
    return request.method == POST


# 登录验证
@app.route('/login', methods=[POST])
def login():
    if check():
        uid = request.form.get("uid")
        pwd = request.form.get("pwd")

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
        if story.register(uid, name, pwd):
            return str(1)
        else:
            return str(0)

    else:
        return str(0)


@app.route('/getStoryList', methods=[POST])
def getStoryList():
    if check():
        type = request.form.get("type")
        page_size = request.form.get("pageSize")
        page_index = request.form.get("pageIndex")
        list = story.getStoyList(type, int(page_size), int(page_index))
        return json.dumps(list)
    else:
        return "查询错误"


@app.route('/')
def hello_world():
    return 'Hello World!'


if __name__ == '__main__':
    app.run()
