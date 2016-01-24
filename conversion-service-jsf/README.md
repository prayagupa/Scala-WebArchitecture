```
/Applications/IntelliJ\ IDEA\ 14\ CE.app/Contents/plugins/maven/lib/maven3/bin/mvn package

vagrant up
vagrant ssh default

sudo service tomcat7 stop && sudo rm -r /var/lib/tomcat7/webapps/conversion-service*
sudo cp /vagrant/target/conversion-service-jsf.war /var/lib/tomcat7/webapps/ && sudo service tomcat7 start
```

hit the url
http://192.168.33.10:8080/conversion-service-jsf