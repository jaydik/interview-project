# Temperature Insights Service
Temperature Insights Service To Get Insights From Current, Past, And Future Weather

## To Build
~**Please Fork First**~

1. After forking the repo, to build the jar: \
    `mvn clean install`
    
2. To run current service in docker (assuming docker installed): \
    `docker-compose up ` --feel free to use `-d` on that if you wish
3. To run in dev env (we use intellij but eclipse should also work) for situations without docker and to develop
    - main class: `com.adhawk.TemperatureInsightsService`
    - program arguments: `server target/classes/temp-service.yml ` \
    
* We use java 1.8        
