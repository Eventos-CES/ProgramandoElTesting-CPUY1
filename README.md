# ADVERTENCIA!!! (17 de marzo)
Esto no está terminado :( 
En el correr de la semana lo completamos, y subimos las ppts.

# Programando el Testing
Taller de TestingUY - Centro de Ensayos de Software \
Campus Party Uruguay - Punta del Este - #CPUY1 \
17 de marzo de 2019

# Acerca del proyecto
## Resumen
La idea es mostrar un ejemplo de automatización web utilizando Selenium. Para esto, usamos como ejemplo la página https://katalon-demo-cura.herokuapp.com/ (provista por [Katalon](https://www.katalon.com/))

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
