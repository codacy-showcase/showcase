import requests
import pg8000.native as pg


def main(req):
    conn = pg.Connection("postgres", password="cpsnow")

    query = "SELECT name FROM users WHERE age=" + req.FormValue("age")
    conn.run(query)

    r = requests.post(
        "http://github.com/codacy-security/showcase/pull/2/checks?check_run_id=20810885289",
        auth=("user", "pass"),
    )

    exit(0)
