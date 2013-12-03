from flask import Flask
app = Flask(__name__)

import json
import socket

import MingleAPI.authentication


@app.route("/")
def health_check():
    return socket.gethostname();

