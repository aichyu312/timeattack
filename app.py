from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.test


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/detail/<idx>')
def detail(idx):
    return render_template('index.html')

# 12? 메인에 바로넣기

@app.route('/post', methods=['POST'])
def save_post():
    print(request)
    title = request.form['title']
    content = request.form['content']
    password = request.form["password"]

    today = datetime.now()
    date = today.strftime('%Y.%m.%d %H:%M:%S')


    doc = {
        'title': title,
        'content': content,
        'date': f'{date}',
        'password': password
    }



    db.memo.insert_one(doc)

    return jsonify({'msg': 'Post 완료!'})


@app.route('/post', methods=['GET'])
def get_post():
    posts = 0


	# // todo
# return jsonify({"posts": posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.test.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
