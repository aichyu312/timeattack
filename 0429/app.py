from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.timeattack_1


@app.route('/')
def index():
    return render_template('index.html')

# @app.route('/detail/<idx>')
# def detail(idx):
#     // todo

@app.route('/post', methods=['POST'])
def save_post():
    url_receive = request.form.get('url_give')
    password_receive = request.form.get('password_give')
    comment_receive = request.form.get('comment_give')
    post_count = db.memopost.estimated_document_count({})

    if post_count == 0:
        max_value = 1
    else:
        # max_value = db.test.find_one(sort=[("idx", -1)])['idx'] + 1 이 부분에 질문이 있어서 아래처럼 구현해도 가능합니다.
        max_value = (list(db.memopost.find({}).sort([("idx", -1)])))[0]['idx'] + 1

    doc = {
        'idx': max_value,
        'url': url_receive,
        'password': password_receive,
        'comment': comment_receive,
        'reg_date': datetime.now()
    }

    db.memopost.insert_one(doc)

    return {"result": "success"}




@app.route('/post', methods=['GET'])
def get_post():
    posts = list(db.memopost.find({}, {'_id': False}).sort("reg_date", -1))
    for a in posts:
        a['reg_date'] = a['reg_date'].strftime('%Y.%m.%d %H:%M:%S')

    return jsonify({"posts": posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.memopost.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)