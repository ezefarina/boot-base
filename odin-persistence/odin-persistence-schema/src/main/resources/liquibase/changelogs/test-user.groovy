package liquibase.changelogs

databaseChangeLog() {
    changeSet(author: "efarina", id: "baseline") {
      sql { """
  insert into person(username, email, password)
  values('odin', 'odin@odin.com', '\$2a\$10\$m7BcPfteOkq4iqe6p8EpWOEqjPb2n0RDr0UUo1rfTFxPs3NwjzZ2K')
"""
      }
    }
}
