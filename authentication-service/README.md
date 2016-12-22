authentication service using servlet
--------------------------

demonstrates log4j2 non-blocking writes as well, `log4j-web % 2.5` just
seems to work for me.

see `NonBlockingLoggingContextSelector extends AsyncLoggerContextSelector `

run
-----

```
sbt jetty:run
```

hit the endpoint at `localhost:9090`

```
tail -f authentication.log 

{"timeMillis":1482398344517,"thread":"qtp1149319664-24","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482398344579,"thread":"qtp1149319664-26","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399228883,"thread":"qtp1149319664-24","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399228937,"thread":"qtp1149319664-26","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399238909,"thread":"qtp1149319664-26","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399238953,"thread":"qtp1149319664-24","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399257830,"thread":"qtp1149319664-24","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399257873,"thread":"qtp1149319664-26","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399566638,"thread":"qtp1149319664-31","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399566679,"thread":"qtp1149319664-32","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399617281,"thread":"qtp1149319664-32","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams true","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399617326,"thread":"qtp1149319664-31","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399675940,"thread":"qtp1149319664-33","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams true","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399675940,"thread":"qtp1149319664-33","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"valid user.","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399675982,"thread":"qtp1149319664-31","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399743182,"thread":"qtp1149319664-24","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399743237,"thread":"qtp1149319664-26","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399771736,"thread":"qtp1149319664-26","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams true","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399771736,"thread":"qtp1149319664-26","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"valid user.","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399771777,"thread":"qtp1149319664-24","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399940374,"thread":"qtp1149319664-28","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399940418,"thread":"qtp1149319664-29","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399956263,"thread":"qtp1149319664-29","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams true","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399956263,"thread":"qtp1149319664-29","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"valid user.","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}
{"timeMillis":1482399956314,"thread":"qtp1149319664-30","level":"INFO","loggerName":"com.authentication.controller.LogonServlet","message":"hasParams false","endOfBatch":true,"loggerFqcn":"org.apache.logging.log4j.spi.AbstractLogger"}

```