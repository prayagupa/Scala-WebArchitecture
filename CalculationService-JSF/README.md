'Calculation-Service' using JSF ManagedBean/ Views
-------------------------------------------------

run
-----

```
vagrant up
vagrant ssh default 

cd /vagrant
sbt package
target/scala-2.11/calculation-service_2.11-1.0.war

sudo service tomcat7 stop && sudo rm -r /var/lib/tomcat7/webapps/calculation-*

sudo cp -r target/scala-2.11/calculation-service_2.11-1.0.war /var/lib/tomcat7/webapps/ && sudo service tomcat7 start

# error on catalina

Jan 3, 2016 6:53:15 PM org.apache.catalina.startup.HostConfig deployDirectory
INFO: Deploying web application directory /var/lib/tomcat7/webapps/ROOT
Jan 3, 2016 6:53:29 PM org.apache.catalina.startup.HostConfig deployDirectories
SEVERE: Error waiting for multi-thread deployment of directories to completehostConfig.deployWar=Deploying web application archive {0}
java.util.concurrent.ExecutionException: java.lang.OutOfMemoryError: Java heap space
	at java.util.concurrent.FutureTask$Sync.innerGet(FutureTask.java:252)
	at java.util.concurrent.FutureTask.get(FutureTask.java:111)
	at org.apache.catalina.startup.HostConfig.deployDirectories(HostConfig.java:1018)
	at org.apache.catalina.startup.HostConfig.deployApps(HostConfig.java:473)
	at org.apache.catalina.startup.HostConfig.start(HostConfig.java:1412)
	at org.apache.catalina.startup.HostConfig.lifecycleEvent(HostConfig.java:312)
	at org.apache.catalina.util.LifecycleSupport.fireLifecycleEvent(LifecycleSupport.java:119)
	at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:90)
	at org.apache.catalina.util.LifecycleBase.setStateInternal(LifecycleBase.java:401)
	at org.apache.catalina.util.LifecycleBase.setState(LifecycleBase.java:346)
	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:1145)
	at org.apache.catalina.core.StandardHost.startInternal(StandardHost.java:782)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1566)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1556)
	at java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:334)
	at java.util.concurrent.FutureTask.run(FutureTask.java:166)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1146)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at java.lang.Thread.run(Thread.java:701)
Caused by: java.lang.OutOfMemoryError: Java heap space
	at java.nio.ByteBuffer.wrap(ByteBuffer.java:367)
	at java.nio.ByteBuffer.wrap(ByteBuffer.java:390)
	at java.lang.StringCoding$StringEncoder.encode(StringCoding.java:254)
	at java.lang.StringCoding.encode(StringCoding.java:289)
	at java.lang.String.getBytes(String.java:954)
	at java.io.UnixFileSystem.getBooleanAttributes0(Native Method)
	at java.io.UnixFileSystem.getBooleanAttributes(UnixFileSystem.java:243)
	at java.io.File.exists(File.java:791)
	at sun.misc.URLClassPath$FileLoader.getResource(URLClassPath.java:1014)
	at sun.misc.URLClassPath$FileLoader.findResource(URLClassPath.java:992)
	at sun.misc.URLClassPath.findResource(URLClassPath.java:166)
	at java.net.URLClassLoader$2.run(URLClassLoader.java:379)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findResource(URLClassLoader.java:376)
	at java.lang.ClassLoader.getResource(ClassLoader.java:986)
	at java.lang.Class.getResource(Class.java:2144)
	at org.apache.catalina.startup.DigesterFactory.register(DigesterFactory.java:206)
	at org.apache.catalina.startup.DigesterFactory.registerLocalSchema(DigesterFactory.java:124)
	at org.apache.catalina.startup.DigesterFactory.newDigester(DigesterFactory.java:73)
	at org.apache.catalina.startup.ContextConfig.createWebXmlDigester(ContextConfig.java:499)
	at org.apache.catalina.startup.ContextConfig.init(ContextConfig.java:816)
	at org.apache.catalina.startup.ContextConfig.lifecycleEvent(ContextConfig.java:363)
	at org.apache.catalina.util.LifecycleSupport.fireLifecycleEvent(LifecycleSupport.java:119)
	at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:90)
	at org.apache.catalina.util.LifecycleBase.setStateInternal(LifecycleBase.java:401)
	at org.apache.catalina.util.LifecycleBase.init(LifecycleBase.java:110)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:139)
	at org.apache.catalina.core.ContainerBase.addChildInternal(ContainerBase.java:895)
	at org.apache.catalina.core.ContainerBase.addChild(ContainerBase.java:871)
	at org.apache.catalina.core.StandardHost.addChild(StandardHost.java:615)
	at org.apache.catalina.startup.HostConfig.deployDirectory(HostConfig.java:1095)
	at org.apache.catalina.startup.HostConfig$DeployDirectory.run(HostConfig.java:1617)
Jan 3, 2016 6:53:33 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-bio-8080"]
Jan 3, 2016 6:53:36 PM org.apache.catalina.startup.Catalina start
INFO: Server startup in 35616 ms

```

```
goto http://192.168.33.10:8080/calculation-service/index.xhtml
```

catalina error
```

Exception in thread "http-bio-8080-exec-13" java.lang.OutOfMemoryError: Java heap space
Exception in thread "http-bio-8080-exec-14" java.lang.OutOfMemoryError: Java heap space
Exception in thread "http-bio-8080-exec-17" java.lang.OutOfMemoryError: Java heap space
Exception in thread "http-bio-8080-exec-19" java.lang.OutOfMemoryError: Java heap space
```

Tests
--------

uses scalatest and JUnit

//TODO test for servlet 