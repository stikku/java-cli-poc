native-image -cp target/fm-jar-with-dependencies.jar -H:ReflectionConfigurationFiles=target/classes/META-INF/native-image/picocli-generated/com.matthias/cli_file_manager/reflect-config.json -H:+ReportUnsupportedElementsAtRuntime --static --no-server com.matthias.clifilemanager.Main
mv com.matthias.clifilemanager.main fmcli