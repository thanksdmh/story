from flask import request, json

from app.models import Story
from . import main

POST = "POST"


def check():
    return request.method == POST


@main.route('/getStoryList', methods=['POST', 'GET'])
def get_story():
    if check():
        param = request.data
        page_info = json.loads(param)
        type = page_info.get("type")
        page_size = int(page_info.get("pageSize"))
        page_index = int(page_info.get("pageIndex"))
        # paginate分页查询
        # result = Story.query.filter_by(content_type=type).paginate(page_index, page_size, False)
        # return json.dumps(result.items, default=Story.to_json)
        # limit 分页查询
        result = Story.query.filter_by(type=type).limit(page_size).offset(
            (page_index - 1) * page_size).all()
        return json.dumps(result, default=Story.to_json)
        # slice 分页查询
        # result = Story.query.filter_by(content_type=type).slice((page_index - 1) * page_size, page_size).all()
        # return json.dumps(result, default=Story.to_json)
    else:
        return "查询错误"
