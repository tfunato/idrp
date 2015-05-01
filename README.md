# idrp

Ingress Damage Report Mail Parser

## Description

```
    javax.mail.internet.MimeMessage msg = ...
    Parser parser = ParserFactory.getParser(msg);
    DamageReportMail reportMail = parser.parse(msg);
```

## Dependency

```xml
	<dependencies>
		<dependency>
			<groupId>com.sun.mail</groupId>
			<artifactId>javax.mail</artifactId>
			<version>1.5.2</version>
		</dependency>
		<dependency>
			<!-- jsoup HTML parser library @ http://jsoup.org/ -->
			<groupId>org.jsoup</groupId>
			<artifactId>jsoup</artifactId>
			<version>1.8.1</version>
		</dependency>
    </dependencies>
```

## Caution

This application should be used at your own risk.

## Licence

Released under the [WTFPL license](http://www.wtfpl.net/).
