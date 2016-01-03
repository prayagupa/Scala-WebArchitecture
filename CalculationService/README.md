
```
vagrant up
vagrant ssh default
/Applications/IntelliJ\ IDEA\ 14\ CE.app/Contents/plugins/maven/lib/maven3/bin/mvn package

jar tvf target/calculation-service.war 
     0 Sun Jan 03 14:47:36 EST 2016 META-INF/
   128 Sun Jan 03 14:47:34 EST 2016 META-INF/MANIFEST.MF
     0 Sun Jan 03 14:47:36 EST 2016 WEB-INF/
     0 Sun Jan 03 14:47:36 EST 2016 WEB-INF/classes/
     0 Sun Jan 03 14:47:36 EST 2016 WEB-INF/classes/com/
     0 Sun Jan 03 14:47:36 EST 2016 WEB-INF/classes/com/pseudo/
     0 Sun Jan 03 14:47:36 EST 2016 WEB-INF/classes/com/pseudo/calculation/
     0 Sun Jan 03 14:47:36 EST 2016 WEB-INF/classes/com/pseudo/calculation/model/
     0 Sun Jan 03 14:47:36 EST 2016 WEB-INF/lib/
    52 Sat Dec 26 14:37:18 EST 2015 index.jsp
   818 Sat Dec 26 17:30:46 EST 2015 index.xhtml
   360 Sat Dec 26 17:01:38 EST 2015 result.xhtml
  2175 Sun Jan 03 14:47:34 EST 2016 WEB-INF/classes/com/pseudo/calculation/model/CalculationBean.class
 85353 Sat Dec 26 13:05:58 EST 2015 WEB-INF/lib/javax.servlet-api-3.0.1.jar
635771 Sat Dec 26 13:05:58 EST 2015 WEB-INF/lib/jsf-api-2.1.13.jar
1990387 Sat Dec 26 13:06:04 EST 2015 WEB-INF/lib/jsf-impl-2.1.13.jar
   743 Sat Dec 26 13:38:24 EST 2015 WEB-INF/web.xml
     0 Sun Jan 03 14:47:36 EST 2016 META-INF/maven/
     0 Sun Jan 03 14:47:36 EST 2016 META-INF/maven/com.pseudo.calculation/
     0 Sun Jan 03 14:47:36 EST 2016 META-INF/maven/com.pseudo.calculation/calculation-service/
  1039 Sat Dec 26 13:33:56 EST 2015 META-INF/maven/com.pseudo.calculation/calculation-service/pom.xml
   133 Sun Jan 03 14:47:36 EST 2016 META-INF/maven/com.pseudo.calculation/calculation-service/pom.properties
   
cd /vagrant
sudo service tomcat7 stop && sudo rm -r /var/lib/tomcat7/webapps/calculation-service*

sudo cp /vagrant/target/calculation-service.war /var/lib/tomcat7/webapps/ && sudo service tomcat7 start

```

goto 

http://192.168.33.10:8080/calculation-service/index.xhtml


see the log at `tail -f /var/lib/tomcat7/logs/catalina.out`

References
------------

https://dzone.com/articles/vagrant

http://www.javacodegeeks.com/2013/10/jsf-tomcat-configuration-example.html