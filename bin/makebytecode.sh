
/opt/java/bin/javac standalone/QueensJava.java
javap -c -cp standalone QueensJava\$Board >Board-java-1.7.0.bytecode

export GROOVY_HOME=/opt/groovy-1.8.0/
/opt/groovy-1.8.0/bin/groovyc standalone/QueensGroovy.groovy
javap -c -cp . Board >Board-groovy-1.8.0.bytecode

export GROOVY_HOME=/opt/groovypp-0.4.279/
/opt/groovypp-0.4.279/bin/groovyc standalone/QueensGroovy.groovy
javap -c -cp . Board >Board-groovypp-0.4.279.bytecode
