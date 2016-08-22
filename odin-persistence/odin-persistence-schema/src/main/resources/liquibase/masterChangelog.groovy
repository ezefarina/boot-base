package liquibase

databaseChangeLog() {
    include(file:'changelogs/baseline.groovy', relativeToChangelogFile:true)
    include(file:'changelogs/test-user.groovy', relativeToChangelogFile:true)
}
