
```
vagrant up
vagrant ssh default
mvn package

cd /vagrant
sudo service tomcat7 stop && sudo rm -r /var/lib/tomcat7/webapps/flights-service*
sudo cp /vagrant/target/flights-service.war /var/lib/tomcat7/webapps/ && sudo service tomcat7 start

```

goto 

http://192.168.33.10:8080/flights-service/index.xhtml


see the println log at `tail -f /var/lib/tomcat7/logs/catalina.out`

References
------------

https://dzone.com/articles/vagrant

http://www.javacodegeeks.com/2013/10/jsf-tomcat-configuration-example.html