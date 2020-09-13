# Felix API
![GitHub release (latest by date)](https://img.shields.io/github/v/release/nKosmos/felix-api?style=flat-square)
The common library for the Felix Server/Client

## What is this?
Felix is the name of our server-side API.

This library simplifies the interaction process and gives access to some model/utility classes

## Import
You can import it using Maven or Gradle: (be sure to change `VERSION` to whatever version you want)

Gradle:
```gradle
dependencies {
	compile 'fr.nkosmos.felix:felix-api:VERSION'
}

repositories {
	maven {
		url = "https://nkosmos.github.io/maven/"
	}
}
```

Maven: (why)
```xml
<dependency>
    <groupId>fr.nkosmos.felix</groupId>
    <artifactId>felix-api</artifactId>
    <version>VERSION</version>
</dependency>
<repository>
    <id>nkosmos</id>
    <name>nkosmos</name>
    <url>https://nkosmos.github.io/maven</url>
</repository>
```

## License
No license, idk why the fuck i'd want a license over that