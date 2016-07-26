package liquibase.changelogs

databaseChangeLog() {
    changeSet(author: "efarina", id: "baseline") {
        createTable(tableName: "person") {
            column(autoIncrement: "true", name: "id", type: "INT") {
                nullable(false)
                primaryKey(true)
            }
            column(name: "identificationnumber", type: "VARCHAR(20)") {
                nullable(false)
            }
            column(name: "firstname", type: "VARCHAR(20)") {
                nullable(false)
            }
            column(name: "lastname", type: "VARCHAR(20)") {
                nullable(false)
            }
        }
        createTable(tableName: "person_loan_application") {
            column(autoIncrement: "true", name: "id", type: "INT") {
                nullable(false)
                primaryKey(true)
            }
            column(name: "person_id", type: "INT") {
                nullable(false)
                foreignKeyName('person_loan_application_person')
                references('person')
            }
            column(name: "amount", type: "FLOAT") {
                nullable(false)
            }
            column(name: "ip", type: "VARCHAR(20)") {
                nullable(false)
            }
            column(name: "datetime", type: "TIMESTAMP", defaultValueDate: 'CURRENT_TIMESTAMP') {
                nullable(false)
            }
            column(name: "approved", type: "BOOLEAN", defaultValueBoolean: false) {
                nullable(false)
            }
        }
    }
}
