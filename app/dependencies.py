from app.models.db import Database
from app.services.admin_service import AdminService

db = Database()
admin_service = AdminService(db)

def get_admin_service():
    return admin_service