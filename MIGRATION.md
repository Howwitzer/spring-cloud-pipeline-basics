# Migration to Spring Cloud Pipelines

- Added Maven wrapper to each project
```bash
$ mvn -N io.takari:maven:wrapper
$ git add .
$ git add -f .mvn
$ git commit -m "Added maven wrapper" 
```
- Added `manifest.yml` to apps
- Added `sc-pipelines.yml`
    - added database and eureka as a required service
- Created cloud foundry spaces
```bash
$ cf login -o ... -a ...
$ cf create-space sc-pipelines-test-message-service
$ cf create-space sc-pipelines-test-billboard-client
$ cf create-space sc-pipelines-stage
$ cf create-space sc-pipelines-prod
```
- Added `<distributionManagement>` section for all projects
- Configured local `~/.m2/setting.xml` to have an entry like this
```
    <server>
      <id>artifactory-qconny2018</id>
      <username>...</username>
      <password>...</password>
    </server>
```
- Uploaded Eureka jar to that Artifactory via `./mvnw clean deploy`
- Added contract tests (one via sc-contract in `message-service` and one in `billboard-client` manually)
- Added `<profiles>` for all types of tests for all projects
  - that way we can control the whole project from root 
- Configured rollback tests via `sc-contract` plugin under `apicompatibility` profile (for `message-service`)
- Configured just echoing of some text under `apicompatibility` profile (for `billboard-client`) to show that it's not mandatory to do that step (you could also remove it from the pipeline)
- Added `smoke` tests (just pining health initially) (initially only for `shortages-prediction-adapters` but could be added for more)
- Added `e2e` tests (just pining health initially) (initially only for `shortages-prediction-adapters` but could be added for more)
- Created the `practical-microservices-db` database service for `spring-cloud-pipelines` prod space
```bash
$ cf create-service p-mysql 100mb practical-microservices-db
```
- Created the `practical-microservices-eureka` app on production
```bash
$ cd eureka-server 
$ cf push -p target/eureka-server-0.0.1.M1.jar
$ cf create-user-provided-service practical-microservices-eureka -r https://practical-microservices-eureka.apps.cf.q.examples.cf
```
- Cloned `spring-cloud-pipelines` and created the pipeline credentials by copying the sample ones from concourse
- Created pipelines from the `spring-cloud-pipeline-basics` but `project-name` must correspond to the `billboard-client` and `message-service`
- Created a `version-billboard-client` and `version-message-service` empty branches. In the `pipeline.yml` in spring-cloud-pipelines
changed the `version` branch to from `version` to `((project-name))-version`

