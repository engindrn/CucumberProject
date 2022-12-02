Feature: DB TEST

  Scenario Outline: DATABASE
    Given Kullanici connection kurar
    Then Kullanici kayitli bilgileri ceker "<quary>" ,"<columnName>"
    And Kullanici bilgileri dogrular
    Examples:
      | quary | columnName |
      |SELECT * FROM jhi_user|ssn|