# Utilizar una imagen base de Tomcat
FROM tomcat:9.0

# Eliminar la aplicación web predeterminada de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copiar el archivo WAR al directorio webapps de Tomcat
COPY target/UserSignup.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar Tomcat
CMD ["catalina.sh", "run"]
