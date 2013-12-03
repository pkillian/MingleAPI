from MingleAPI import app

@app.route("/auth/login")
def login():
    return "login"

@app.route("/auth/logout")
def logout():
    return "logout"

