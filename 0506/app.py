from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.mymemo


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/detail/<idx>')
def detail(idx):
      #todo1
		return render_template('index.html')

@app.route('/articleList', methods=['GET'])
# def get_article_list():
#     article_list = 0 # todo
#
#     for article in article_list:
# 		  article['reg_date'] = article['reg_date'].strftime('%Y.%m.%d %H:%M:%S')
#
#     return jsonify({"article_list": article_list})

# Create
@app.route('/article', methods=['POST'])
def create_article():

    title_receive = request.form['title']
    content_receive = request.form['content']
    password_receive = request.form["pw"]

    print(title_receive,content_receive,password_receive)

    # today = datetime.now()
    # mytime = today.strftime('%Y-%m-%d-%H-%M-%S')
    # date = today.strftime('%Y.%m.%d')


    doc = {
        'title': title_receive,
        'content': content_receive,
        'pw': password_receive,
    }

    db.mymemo.insert_one(doc)
    return {"result": "success"}

# Read
@app.route('/article', methods=['GET'])
def read_article():
    article = 0 #todo
    return jsonify({"article": article})

# Update
@app.route('/article', methods=['PUT'])
def update_article():
    # todo
    return {"result": "success"}

# Delete
@app.route('/article', methods=['DELETE'])
def delete_article():
    # todo
    return {"result": "success"}

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)