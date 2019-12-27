# Docs
* **Wiki and Reasoning** https://github.com/remkop/picocli/wiki/Build-great-native-CLI-apps-in-Java-with-GraalVM-and-Picocli
* Annotation processor can be use to create a reflection config file. This is required in order to tell GraalVM what reflection is required. (Reflection does not worth with ahead of time compilation).
    * https://github.com/remkop/picocli/blob/master/RELEASE-NOTES.md#-annotation-processor
    * https://picocli.info/#_annotation_processor
    * Annotation processor create a config files (in target/classes/META-INF/native-image) required to build a native image using graalvm
    * How to use (tested for maven): https://github.com/remkop/picocli/tree/master/picocli-codegen#ide
    * We are setting it as part of `maven-compiler-plugin` in `pom.xml`

## Limitations:
* GraalVM does not currently support cross-compilation. a.k.a. you need a windows hows to compile to windows.
    * https://github.com/oracle/graal/issues/1446
* Tested only with Java 8
    
# Building:
* `mvn clean install` (this will also generate the reflection config file)
* `docker run -it -v C:\dev\trees\cli_file_manager:/usr/games oracle/graalvm-ce tail -f /dev/null`
    * Creates a running container with graalvm installed in it
* exec into container
    * `gu install native-image`
    * `cd /usr/games`
    * `./build_native.sh`
    * Output is `fmcli`
    * To test runtime duration: `time ./fmcli file src dst`

# Future research:
* Command line TAB completion: https://picocli.info/autocomplete.html
* Has support for spring ... but do i really need that? Plus it includes spring classes to compiled file.
* Interactive password can be done **easily**: https://picocli.info/#_interactive_password_options