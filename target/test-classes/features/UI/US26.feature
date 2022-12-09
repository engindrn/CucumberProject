@US026
Feature: US026 İletişim Mesajı (Contact messages)

  Background:Ortak adimlar

    Given USyirmiAlti Hasta Medunna adresine gider
    When USyirmiAlti Hasta Sing in simgesine tiklar
    Then USyirmiAlti Hasta Sing in e tiklar
    And USyirmiAlti Hasta Username girer
    And USyirmiAlti Hasta Password girer
    And USyirmiAlti Hasta Sing in butonuna tiklar
    And USyirmiAlti Kullanici 3 saniye bekler
    And USyirmiAlti Hasta Contact a tiklar


  @US026/1
  Scenario:"Bilgi sahibi olmak veya bir endişesini açıklamak isteyen herhangi bir kullanıcı, bilgi sağlamak veya bilgi
            talep etmek için İletişim portalını kullanabilir"

    Given USyirmiAlti Contact sayfasinda oldugu dogrulanir
    Then USyirmiAlti Location Email Call bilgileri dogrulanir
    And USyirmiAlti Mesaj Formunun oldugu dogrulanir
    And USyirmiAlti sayfayi kapatir


  @US026/2
  Scenario Outline:Kullanıcı "Name, Email, Subject, Message" bölümlerine data girebilmeli ve mesajını gönderebilmeli.

    Given USyirmiAlti Mesaj formuna "<Name>" ,"<Email>", "<Subject>", "<Message>" girilir
    Then USyirmiAlti Send butonuna tiklanir mesaj gonderilir
    And USyirmiAlti Sistem mesaj gonderilme isleminin basariyla tamamlandigina dair bilgi mesaji verir
    And USyirmiAlti sayfayi kapatir

    Examples:
      | Name          | Email | Subject | Message      |
      | kullanici adi | sifre | deneme  | Messaj alani |



