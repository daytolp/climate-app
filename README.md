# climate-app
Prueba técnica, consumo de la API OpenWeather

Requisitos 
- JDK Versión 1.8.X
- Spring tools suite de preferencia, o InteLlij
- Base de datos embebida H2
- Maven versión 3.3.3 o superior
- Lombook 
- Git instalado en el ordenador

Pasos:
- Abrir la terminal en una carpeta
- Clonar el repositorio
- Moverse a la ruta del proyecto
- Moverse a la rama master con el comando git checkout master
- Tener los cambios actualizados usando el comando git pull
- Ejecutar  el comando mvn clean
- Ejecutar el comando mvn install
- Abrir el proyecto con spring tools suite 

En caso de no contar con lombook instalado en Spring tools suite, seguir este tutorial: 
https://programmerclick.com/article/73231558359/

Una vez instalado lombook y de haber reiniciado el Spring tools suite, ejecutar el proyecto.

Ruta de consumo de servicios: 
http://localhost:8080/api/check-weather?city=London
http://localhost:8080/api/check-weather-top

Nota: si deseas conocer más sobre openweathermap, se recomienda visitar la api para ver su funcionamiento en el siguiente enlace: https://openweathermap.org/api
Para hacer uso de la api se recomienda crear una cuenta de usuario y generar un key para usarlo en las peticiones que se realicen.

