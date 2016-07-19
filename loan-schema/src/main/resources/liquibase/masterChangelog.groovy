package liquibase

databaseChangeLog() {
    include(file:'changelogs/baseline.groovy', relativeToChangelogFile:true)
}
