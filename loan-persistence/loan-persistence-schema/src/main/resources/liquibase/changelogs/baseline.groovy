package liquibase.changelogs

databaseChangeLog() {
    changeSet(author: "efarina", id: "baseline") {
        createTable(tableName: "person") {
            column(autoIncrement: "true", name: "id", type: "INT") {
                nullable(false)
                primaryKey(true)
            }
            column(name: "username", type: "VARCHAR(40)") {
                nullable(false)
            }
            column(name: "email", type: "VARCHAR(120)") {
                nullable(false)
            }
            column(name: "password", type: "VARCHAR(200)") {
                nullable(false)
            }
        }
    }
}
