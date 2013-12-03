from MingleAPI import app

@app.route("/msg/send")
def send_message():
    return "sent message"

@app.route("/msg/recv")
def receive_message():
    return "got message"
