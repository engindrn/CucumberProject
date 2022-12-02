@API
Feature: US07 API kullanarak randevular görüntülenebilmelidir.
  Scenario: API TEST
    Given USyedi kullanici url yi ayarlar
    Then USyedi kullanici icin ilgili endpointe request gonderir
    Then USyedi status code 200 olmali
    Then USyedi appointment icin id, 345716 olmali

