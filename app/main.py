from fastapi import FastAPI
from fastapi.responses import HTMLResponse

from contextlib import asynccontextmanager
from datetime import datetime



from app.core.config import PROJECT_NAME, VERSION
from app.services.admin_service import AdminService

from app.api.routes.auth import router as auth_router

from app.dependencies import db

@asynccontextmanager
async def lifespan(app: FastAPI):
     # Startup
    print("Starting up...")
    
    yield
    print("Shutting down...")


# Creazione app FastAPI
app= FastAPI(
    title=PROJECT_NAME,
    version=VERSION,
    description="TO DEFINE",
    lifespan=lifespan
)
app.include_router(auth_router)

@app.get("/",response_class=HTMLResponse)
async def root():
    return f"""
    <html>
        <head>
            <title>{PROJECT_NAME}</title>
            <style>
                body {{ font-family: Arial, sans-serif; margin: 40px; }}
                .container {{ max-width: 800px; margin: 0 auto; }}
                .link {{ 
                    display: inline-block; 
                    margin: 10px; 
                    padding: 10px 20px; 
                    background: #007bff; 
                    color: white; 
                    text-decoration: none; 
                    border-radius: 5px;
                }}
                .link:hover {{ background: #0056b3; }}
            </style>
        </head>
        <body>
            <div class="container">
                <h1>Welcome to {PROJECT_NAME}</h1>
                <p>Version: {VERSION}</p>
                
                <h3>Quick Links:</h3>
                <a class="link" href="/docs">📚 API Documentation</a>
                <a class="link" href="/health">❤️ Health Check</a>
                
                <h3>Available Endpoints:</h3>
                <ul>
                    <li><a href="/auth/register">Register</a></li>
                    <!-- Aggiungi altri endpoint qui -->
                </ul>
            </div>
        </body>
    </html>
    """
@app.get("/health")
async def health_check():
    return {
        "status": "healthy",
        "timestamp": datetime.now().isoformat(),
        "service": PROJECT_NAME,
        "version": VERSION
    }

# Solo per sviluppo
if __name__ == "__main__":
    import uvicorn
    uvicorn.run(
        "app.main:app",
        host="0.0.0.0",
        port=8000,
        reload=True,
        log_level="debug"
    )