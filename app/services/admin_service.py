from app.schemas.admin_schema import AdminCreate
from app.core.security import verify_password, hash_password
from app.models.db import Database
from app.models.admin_model import Admin
class AdminService:
    def __init__(self, db : Database):
        self.db = db

    def create_admin(self, email, password, name, phone_number):
        conn = self.db.get_connection()
        cur = conn.cursor()
        try:
            hashed_password = hash_password(password)
            QUERY = "INSERT INTO pt_admin (email, password_hash, name, phone_number) VALUES (?, ?, ?, ?)"
            cur.execute(QUERY, (email, hashed_password, name, phone_number))
            conn.commit()
            
            return Admin(name = name, email = email, hash_pw=hashed_password, phone_number=phone_number)
        except Exception as e:
            print(e)
