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
    title_receive = request.form['title_give']
    password_receive = request.form['password_give']
    comment_receive = request.form['comment_give']
    time_receive = request.form['time_give']

    doc = {
        'title': title_receive,
        'password': password_receive,
        'time': time_receive,
        'comment': comment_receive
    }

    db.memopost.insert_one(doc)

    return jsonify({'msg': '저장 완료!'})




@app.route('/post', methods=['GET'])
def get_post():
    posts = request.args.get('sample_give')
    print(posts)
    return jsonify({"msg": "Get 요청 완료 !"})




@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.test.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)