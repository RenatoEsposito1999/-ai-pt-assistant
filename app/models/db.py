# db.py
import sqlite3
from pathlib import Path

DB_PATH = Path(__file__).parent / "pt.db"
class Database():
    def __init__(self):
        self.create_tables()

    def create_tables(self):
        """Crea le tabelle se non esistono"""
        conn = self.get_connection()
        try:
            cur = conn.cursor()
            cur.execute("""
            CREATE TABLE IF NOT EXISTS pt_admin (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                email TEXT UNIQUE NOT NULL,
                password_hash TEXT NOT NULL,
                name TEXT NOT NULL,
                phone_number TEXT
            )
            """)
            conn.commit()
        finally:
            conn.close()


    def get_connection(self):
        """Return a connection to a db"""
        return sqlite3.connect(DB_PATH)


