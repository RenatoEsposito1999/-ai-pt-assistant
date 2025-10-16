from fastapi import FastAPI
from pydantic import BaseModel
from db import get_connection_AND_cursor, init_db

#app.post normalmente per creare dati
#app.get normalmente per leggere dati
#app.put per aggiornare i dati
#app.delete per eliminarli. 


def main():
    init_db()
    print("Database ready!")


# Chiamare la generate db. 
class Item(BaseModel):
    name: str
    description: str | None = None
    price: float
    tax: float | None = None
app = FastAPI()
@app.get("/items/{id}")
async def create_item(id):
    print(id)
    return id





if __name__ == "__main__":
    main()