from sqlalchemy import *
from sqlalchemy.engine.url import URL
from contextlib import closing
from flask import Flask
app = Flask(__name__)

import json
import socket

import MingleAPI.settings
import MingleAPI.authentication
import MingleAPI.messaging

@app.route("/")
def health_check():
    return socket.gethostname();

def connect_db():
    return create_engine(URL(**settings.DATABASE))

def init_db():
    db = connect_db();
    metadata = MetaData(db)
    tbl = Table("user_profiles", metadata,
            Column('username', String),
            Column('gender', String(1)),
            Column('topics', Integer))
    tbl.create()

