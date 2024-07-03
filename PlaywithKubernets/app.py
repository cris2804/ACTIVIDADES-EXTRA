import os

# Define el directorio donde se encuentran las imágenes
directorio = './Imagenes'

# Lista todos los archivos en el directorio
archivos = os.listdir(directorio)

# Filtra solo los archivos que contienen 'imagen' en su nombre
imagenes = [archivo for archivo in archivos if 'imagen' in archivo]

# Renombra cada archivo
for archivo in imagenes:
    nueva_ruta = os.path.join(directorio, archivo.replace('imagen', 'Untitled '))
    vieja_ruta = os.path.join(directorio, archivo)
    os.rename(vieja_ruta, nueva_ruta)

print("Archivos renombrados con éxito.")
