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

Otra manera de ejecutar la aplicación de forma rápida es: 
- Abrir la terminal en la raíz del proyecto
- Ejecutar  el comando mvn clean
- Ejecutar el comando mvn install
- Ejecutar el comando java -jar ./target/clima-app-0.0.1-SNAPSHOT.jar
- Nota: si llega a varíar el nombre del jar  (clima-app-0.0.1-SNAPSHOT.jar) que genera al compilarse con el comando mvn install, cambiarlo en el comando de ejcucipon del jar.
- Para salirse de la ejecución de la aplicación en la terminal presionar las teclas CTRL + c

Para abrir la consola de H2 es necesario tener la aplicación ejecutandose y usar esta ruta en el navegador
http://localhost:8080/h2-console
driver class: org.h2.Driver

jdbc url: jdbc:h2:mem:testdb

usuario: sasa

password: sasa



Nota: si deseas conocer más sobre openweathermap, se recomienda visitar la api para ver su funcionamiento en el siguiente enlace: https://openweathermap.org/api
Para hacer uso de la api se recomienda crear una cuenta de usuario y generar un key para usarlo en las peticiones que se realicen.

