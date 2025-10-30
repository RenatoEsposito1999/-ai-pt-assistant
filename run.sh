#!/usr/bin/env bash

# Imposta il path a JavaFX (stesso che usi manualmente)
FX_PATH="/Users/renatoesposito/javafx-sdk-25.0.1/lib"

# Compila tutto
#javac --module-path "$FX_PATH" --add-modules javafx.controls,javafx.fxml \
#      -cp "lib/*" -d out src/**/*.java

#find src -name "*.java" > sources.txt
#javac --module-path "$FX_PATH" --add-modules javafx.controls,javafx.fxml \
#      -cp "lib/*" -d out @sources.txt

javac --module-path "$FX_PATH" --add-modules javafx.controls,javafx.fxml \
      -cp "lib/*" -d out src/*.java src/**/*.java

# Se la compilazione ha avuto successo:
if [ $? -eq 0 ]; then
  # Esegui
  java --module-path "$FX_PATH" --add-modules javafx.controls,javafx.fxml \
       -cp "out:lib/*" src.MainApp
else
  echo "Compilazione fallita, non eseguo."
fi
