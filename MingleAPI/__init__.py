from flask import Flask
import json
import socket

app = Flask(__name__)

@app.route("/")
def health_check():
    return socket.gethostname();
