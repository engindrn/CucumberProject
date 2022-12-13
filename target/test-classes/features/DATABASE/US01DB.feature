@DBTest
Feature: US01DatabaseTest
  Scenario Outline: kullanici Db Test
    Given CE kullanici connection kurar
    And CE tum yeni kayitli biligileri alir "<query>" ve "<columnName>"
    Then CE kulanici bilgilerini dogrular
    Examples:test verileri
      |query|columnName|
      |select * from public.jhi_user|ssn|