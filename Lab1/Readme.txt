Código de ejemplo de una comunicación Cliente-Servidor sobre UDP

Este código es la base para la práctica de transmisión UDP, donde se debe entregar lo siguiente:

1.	Captura de pantalla con datos de la interfaz utilizada para el envío del paquete del lado del cliente
2.	Captura de pantalla con datos de la interfaz utilizada para el envío del paquete del lado del servidor
3.	Captura de pantalla del puerto y proceso del cliente
4.	Captura de pantalla del puerto y proceso del servidor
5.	Video de la ejecución el programa desde Eclipse o el IDE de su preferencia en el lado del servidor
6.	Captura de pantalla del mensaje desplegado en el lado del cliente
7.	Grafico explicativo del viaje del paquete por los dispositivos involucrados

Las capturas de pantalla y el video subirlos al Dropbox https://www.dropbox.com/sh/d393wo32q8ko7pr/AADxSgbiNGnzW9uTSW4b3LGDa?dl=0
En Github solo subir el código fuente modificado.

Para los puntos 1 y 2, si la prueba se la hace en Windows usar el comando ipconfig -all
Para los puntos 1 y 2, si la prueba se la hace en Linux usar el comando ifconfig
Para los puntos 3 y 4, si la prueba se la hace en Windows usar el comando netstat –ano

Si se requiere eliminar procesos en Windows:
1. Identificar el proceso con el comando netstat -ano
2. Eliminar el proceso con el comando taskkill -pid <#proceso> /f

Si se requiere eliminar procesos en Linux:
1. Identificar el proceso con el comando lsof -i:<port>
2. Eliminar el proceso con el comando kill <pid>
