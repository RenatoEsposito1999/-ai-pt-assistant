from fastapi import APIRouter, Form, Depends
from fastapi.responses import HTMLResponse

from app.schemas.admin_schema import AdminCreate, AdminResponse

from app.dependencies import get_admin_service

router = APIRouter(prefix="/auth", tags=["authentication"])


@router.get("/register", response_class=HTMLResponse)
async def register_page():
    return """
    <html>
        <head>
            <title>Registrazione</title>
            <style>
                body { font-family: Arial; margin: 40px; }
                form { max-width: 400px; }
                input { width: 100%; padding: 8px; margin: 5px 0; }
                button { background: #007bff; color: white; padding: 10px; border: none; }
            </style>
        </head>
        <body>
            <h2>Registrazione Nuovo Utente</h2>
            <form action="/auth/register" method="post">
                <input type="email" name="email" placeholder="Email" required><br>
                <input type="password" name="password" placeholder="Password" required><br>
                <input type="text" name="name" placeholder="Username" required><br>
                <input type="text" name="phone_number" placeholder="Phone number" required><br>
                <button type="submit">Registrati</button>
            </form>
            <p><a href="/">← Torna alla home</a></p>
        </body>
    </html>
    """

@router.post("/register", response_model=AdminResponse)
async def register_action(
    name: str = Form(...),
    email: str = Form(...),
    password: str = Form(...),
    phone_number: str = Form(...),
    admin_service = Depends(get_admin_service)
    ):
    admin = admin_service.create_admin(email = email, name = name, password=password, phone_number=phone_number)
    print(admin)
    return AdminResponse.model_validate(admin)