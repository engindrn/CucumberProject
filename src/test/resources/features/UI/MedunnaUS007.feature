@US007
  Feature:US007 Hastalar randevu tarihi oluşturabilmelidir

    Background:Ortak adimlar

      Given USyedi Hasta Medunna adresine gider
      When USyedi Hasta Sing in simgesine tiklar
      Then USyedi Hasta Sing in e tiklar
      And USyedi Hasta Username girer
      And USyedi Hasta Password girer
      And USyedi Hasta Sing in butonuna tiklar
      And USyedi Hasta My Pages(PATIENT) e tiklar
      And USyedi Hasta Make an Appointment e tiklar
      And USyedi Hasta Phone numarasini girer

    @US07/1
    Scenario:Kullanıcı geçerli tarih girmelidir. (güncel tarihi secebilmelidir)

          Given USyedi Hasta Appointment DateTime e guncel tarihi girer
          Then USyedi Hasta Send an Appointment Request e tiklar
          And USyedi Kullanici 1 saniye bekler
          Given USyedi Guncel tarihle randevu talebinin kaydedildigi dogrulanir
          And USyedi Sayfayi kapatir

    @US07/2
    Scenario:Kullanıcı geçerli tarih girmelidir. (gelecekteki tarihleri secebilmelidir)

            Given USyedi Hasta Appointment DateTime e gelecekte bir tarih girer
            Then USyedi Hasta Send an Appointment Request e tiklar
            And USyedi Kullanici 1 saniye bekler
            Given USyedi Gelecekteki tarihle randevu talebinin kaydedildigi dogrulanir
            And USyedi Sayfayi kapatir


    @US07/4
    Scenario:Tarih sırası gün/ay/yıl şeklinde olmalıdır.

            Given USyedi Hasta Appointment DateTime e GUN-AY-YIL formatta tarihi girer
            Then USyedi Formatin GUN-AY-YIL seklinde oldugu dogrulanir
            And USyedi Sayfayi kapatir

    @US07/5negatif
    Scenario:Tarih sırası ay/gün/yıl (ay/gün/yıl) şeklinde olmamalıdır.

            Given USyedi Hasta Appointment DateTime e  AY-GUN-YIL formatta tarihi girer
            Then USyedi Formatin AY-GUN-YIL seklinde olmadigi dogrulanir
            And USyedi Sayfayi kapatir

    @US07/3negatif
    Scenario:Kullanıcı geçerli tarih girmelidir. (gecmis tarihleri secememelidir)

      Given USyedi Hasta Appointment DateTime e gecmis bir tarih girer
      Then USyedi Hasta Send an Appointment Request e tiklar
      And US06 Kullanici 1 saniye bekler
      Given USyedi Gecmis tarihle randevu talebinin olusturalamadigi dogrulanir
      And USyedi Sayfayi kapatir
