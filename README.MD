# Felix-Lib ![GitHub release (latest by date)](https://img.shields.io/github/v/release/nKosmos/felix-lib?style=flat-square)

The common library for the Felix API server/client & Felix IPC.

## What is this?
Felix is the name of our server/client communication API & IPC Daemon.

This library simplifies the interaction process while also giving access to some common entity classes.

## Import
You can import it using Maven or Gradle: (be sure to change `VERSION` to whatever version you want)

Gradle:
```gradle
dependencies {
    compile 'com.github.nkosmos:felix-lib:VERSION'
}

repositories {
    maven {
        url = 'https://jitpack.io'
    }
}
```

Maven: (why... stop using maven... please...)
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.nkosmos</groupId>
    <artifactId>felix-lib</artifactId>
    <version>VERSION</version>
</dependency>
```

## License
This project is under the [GNU LGPL v3.0](https://github.com/nkosmos/felix-lib/blob/master/LICENSE) license.