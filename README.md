# Les tondeuses

# Run tests
    mvn test

# Execute main from command line
    mvn exec:java -Dexec.args="-f src/test/resources/input.txt"

# Package then run test
    mvn clean package
    java -jar target/les-tondeuses-1.0-SNAPSHOT-jar-with-dependencies.jar -f src/test/resources/input.txt
