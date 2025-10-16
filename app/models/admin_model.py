
class Admin:
    # Solo struttura dati + metodi semplici
    def __init__(self, name="", email="", hash_pw="", phone_number =""):
        self.name = name
        self.email = email
        self.hash_pw = hash_pw 
        self.phone_number = phone_number
    def to_dict(self):
        return {
            'name' : self.name,
            'email' : self.email,
            'hash_pw': self.hash_pw,
            'phone_number': self.phone_number
        }