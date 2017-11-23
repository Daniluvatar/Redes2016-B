Código de ejemplo de una comunicación Cliente-Servidor sobre UDP

Este código es la base para la práctica de transmisión UDP, donde se debe entregar lo siguiente:

1.	Captura de pantalla con datos de la interfaz utilizada para el envío del paquete del lado del cliente
2.	Captura de pantalla con datos de la interfaz utilizada para el envío del paquete del lado del servidor
3.	Captura de pantalla del puerto y proceso del cliente
4.	Captura de pantalla del puerto y proceso del servidor
5.	Captura de pantalla del mensaje desplegado en el lado del cliente
6.	Grafico explicativo del viaje del paquete por los dispositivos involucrados

Las capturas de pantalla incluirlo en el informe de laboratorio.
El código utilizado debe ser subido en Github, en el informe de laboratorio NO debe ir código fuente, solo se debe incluir el enlace respetivo a Github.

Para los puntos 1 y 2, si la prueba se la hace en Windows usar el comando ipconfig -all
Para los puntos 1 y 2, si la prueba se la hace en Linux usar el comando ifconfig
Para los puntos 3 y 4, si la prueba se la hace en Windows usar el comando netstat –ano

Si se requiere eliminar procesos en Windows:
1. Identificar el proceso con el comando netstat -ano
2. Eliminar el proceso con el comando taskkill -pid <#proceso> /f

Si se requiere eliminar procesos en Linux:
1. Identificar el proceso con el comando lsof -i:<port>
2. Eliminar el proceso con el comando kill <pid>
