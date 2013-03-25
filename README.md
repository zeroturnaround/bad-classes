Getting Started
====================

Have you ever seen java.lang.UnsupportedClassVersionError and all the extra information it provides is "bad version number in .class file"? If you found this project then you probably have! Well, the thing with this error is that it never tells you which class it is complaining about. If your project is complex enough then finding the culprit is as complex. To alleviate this problem I've written a small utility that helps you find offending class files.

The following command will find all Java 1.3 class files from someJarfile.jar

```bash
  java -Dversion=1.3 -jar target/bad-classes.jar someJarFile.jar 
```

You want to process more files at a time? Sure thing. The utility takes any number of ZIP files as arguments.
