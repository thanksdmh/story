from flask import request, json

from app.models import Story
from . import main

POST = "POST"


def check():
    return request.method == POST


@main.route('/getStoryList', methods=['POST', 'GET'])
def getStoryList():
    if check():
        param = request.data
        pageInfo = json.loads(param)
        type = pageInfo.get("type")
        page_size = pageInfo.get("pageSize")
        page_index = pageInfo.get("pageIndex")
        # story = StoryApi()
        result = Story.query.filter_by(content_type=type).all()
        # strJson = json.dumps(result, default=Story.to_json)
        return json.dumps(result, default=Story.to_json)
        # return story.getStoyList(int(type), int(page_size), int(page_index))
    else:
        return "查询错误"
