from flask import Flask
app = Flask(__name__)

import json
import socket

import MingleAPI.authentication
import MingleAPI.messaging

@app.route("/")
def health_check():
    return socket.gethostname();

