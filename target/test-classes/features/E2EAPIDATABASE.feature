Feature: E2E Test

  Scenario Outline: API-DATABE

    Given yeni kisiler olusturmak icin register bilgilerini girer "<SSN>", "<firstname>", "<lastname>", "<username>", "<email>", "<password>"
    Then girilen bilgileri post yapar
    And olusturdugu kisi bilgilerini dogrular
    Examples:
      | SSN | firstname | lastname | username | email | password |
      |255-55-6363|Durdu1|Durdu2|durdu|durdu@gmail.com|123456Durdu.|
