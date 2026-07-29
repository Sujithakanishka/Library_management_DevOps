FROM tomcat:10.1-jdk21

COPY target/library_management.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
