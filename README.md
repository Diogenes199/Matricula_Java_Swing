# Matricula_Java_Swing


## Compilado para JDK 21

### Limpiar

```bash
rm -rf ./build/classes \
rm -rf ./dist
```

### Compilar

```bash
javac  -Xlint:deprecation -Xlint:unchecked -d ./build/classes -cp ./lib/* src/**/*.java
```

### Copiado imagenes al compilado

```bash
cp -r ./src/Logos ./build/classes/Logos/
```

### Empaquetar

```bash
jar -cvfm dist/sistemamatricula.jar manifest.mf -C build/classes .
```

### contenido de jar

```bash
jar -tf dist/sistemamatricula.jar
```



### Dependencias

```bash
cp -r ./lib ./dist
```

### Ejecutar

```bash
java -jar dist/sistemamatricula.jar
```

#### Autor: Donatelo
