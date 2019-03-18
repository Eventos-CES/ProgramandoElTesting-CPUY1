# ADVERTENCIA!!! (17 de marzo)
Esto no está terminado :( 
En el correr de la semana lo completamos, y subimos las ppts.

# Programando el Testing
Taller de TestingUY - Centro de Ensayos de Software \
Campus Party Uruguay - Punta del Este - #CPUY1 \
17 de marzo de 2019 \
[Ver presentación](resources/Presentacion-ProgramandoElTesting.pdf)

# Acerca del proyecto
## Resumen
La idea es mostrar un ejemplo de automatización web utilizando Selenium. Para esto, usamos como ejemplo la página https://katalon-demo-cura.herokuapp.com/ (provista por [Katalon](https://www.katalon.com/))

El guión de prueba consiste en:
1. Login
![Alt text](resources/images/Login.png?raw=true "Title")
2. Ingresar una reservación
![Alt text](resources/images/MakeAppointment.png?raw=true "Title")
3. Verificar la reservación
![Alt text](resources/images/AppointmentConfirmation.png?raw=true "Title")

## Requisitos
- Java JDK 1.8
  - https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
  - [En Windows] Una vez instalado deben [setear las variables de entorno](https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=389:configurar-java-en-windows-variables-de-entorno-javahome-y-path-cu00610b&catid=68&Itemid=188) 
- Eclipse con soporte Java + Junit
  - https://www.eclipse.org/downloads/packages/ ("Eclipse for Java Developers")

## Librerías utilizadas
- JUnit 5
  - https://junit.org/junit5/ 
  - No es necesario descargarlo. Viene incluido en Eclipse desde la versión Oxygen 4.7.
- Selenium 
  - Selenium Standalone Server
    - https://www.seleniumhq.org/download/
  - También se debe utilizar un driver para controlar el navegador
    - Para Google Chrome: ChromeDriver
      - https://sites.google.com/a/chromium.org/chromedriver/downloads
    - Para Mozilla Firefox: Mozilla GeckoDriver
      - https://github.com/mozilla/geckodriver/releases
    - Cualquiera que decidan usar, deben descomprimirlo

## ¿Cómo descargo el proyecto?
Antes de descargarlo, ¿Miraste la presentación? ¿Intentaste resolverlo por tí mismo? Recuerda que la idea es aprender :)
En Eclipse:
1. File -> Import
2. Projects from Git
3. Clone URI
4. Ingresan la ruta que obtienen al presionar el botón verde "Clone or download" (git)
5. Siguiente, siguiente...
6. Luego que el proyecto se descargue, presionan botón derecho sobre la raíz del mismo -> Properties
7. Java Build Path
8. Libraries
9. Seleccionan selenium-standalone-server y presionan "Edit"
10. Buscan el archivo jar en su PC
11. Apply and close

### Configurar driver
El proyecto viene por defecto configurado para correr con Firefox, pero tienen código comentado indicando la alternativa para Chrome.
En todos los casos deberán setear la variable de sistema correspondiente al driver donde se encuentra localizado el ejecutable.
Por ejemplo, para Firefox:
```
System.setProperty("webdriver.gecko.driver", "C:\\Test\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
```
(Si observan la ruta en windows queda con doble \\, esto es correcto)

## ¿Cómo ejecuto un caso de prueba?
Pueden ejecutar tanto una clase entera como un método test en particular presionando botón derecho sobre la clase/el nombre del método -> Run as -> Junit Test
