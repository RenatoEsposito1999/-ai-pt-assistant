from pydantic import BaseModel, EmailStr

class AdminCreate(BaseModel):
    name: str 
    email: EmailStr
    password: str
    phone_number : str

class AdminResponse(BaseModel):
    name: str
    email: str
    phone_number : str

    class Config:
        from_attributes = True  # Importante per convertire da oggetti DB