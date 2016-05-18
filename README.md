# Formation Selenium

## Requirements:

- Firefox
- AppDemo + play1.2 + java7
- JDK8
- Maven 3
- Eclipse Mars JEE
- Local maven repository (if no internet)
- Selenium Server jars
- Git bash if not linux

## Installation machine
Extract the zip to the folder ~/formation 


### AppDemo
Check where is installed Java 7.

    update-java-alternative -l

Update AppDemo `run.sh` with the right java 7 location

Try to launch AppDemo with run.sh

### Maven installation

- extract maven to your `/usr/local/apache-maven/`
- add to your .bashrc:

        export M2_HOME=/usr/local/apache-maven/apache-maven-3.3.9
        export M2=$M2_HOME/bin
        export PATH=$M2:$PATH

- create a .m2 folder and copy the repository content

### Eclipse

- Extract eclipse to formation folder



