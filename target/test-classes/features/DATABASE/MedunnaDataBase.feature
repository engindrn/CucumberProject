Feature: DB kullanarak randevuları doğrulanabilmelidir.
  @DBTest
  Scenario: DataBase Test
    Given USYEDI Kullanici Database baglanir
    And USYEDI Kullanici randavu bilgilerini ceker
    Then USYEDI Kullanici randevu bilgilerini dogrular
