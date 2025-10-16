# db.py
import sqlite3
from pathlib import Path

DB_PATH = Path(__file__).parent / "pt.db"

def get_connection_AND_cursor():
    """Ritorna una connessione al database."""
    conn = sqlite3.connect(DB_PATH)
    #conn.row_factory = sqlite3.Row  # opzionale: permette di accedere ai campi per nome
    return conn, conn.cursor()

def init_db():
    """Create tables if not exist."""
    conn, cur = get_connection_AND_cursor()
    #cur = conn.cursor()

    cur.execute("""
    CREATE TABLE IF NOT EXISTS pt_users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        username TEXT UNIQUE NOT NULL,
        email TEXT UNIQUE NOT NULL,
        password_hash TEXT NOT NULL,
        name TEXT NOT NULL,
        surname TEXT NOT NULL,
        age INTEGER,
        phone_number TEXT,
        role TEXT,
        is_active BOOLEAN DEFAULT 1
    )
    """)

    conn.commit()
    conn.close()

