@US023
  Feature: Fatura Ödemesi (Staff)

 @US023-1
 Scenario: Hastanin fatura olusturabilmesi icin durumu Doktor tarafindan tamamlandi (Completed) olmasi gerekir

         Given USyirmiuc Doktor Medunna adresine gider
         When USyirmiuc Doktor Sing in simgesine tiklar
         And USyirmiuc Doktor Sing in e tiklar
         And USyirmiuc Doktor Username girer
         And USyirmiuc Doktor Password girer
         And USyirmiuc Doktor Sing in butonuna tiklar
         And USyirmiuc Doktor My Page butonuna tiklar
         And USyirmiuc Doktor My Page sekmesinden My Appointments butonuna tiklar
         And USyirmiuc Doktor islemleri tamamlanan hastasi icin Edit butonuna tiklar
         And USyirmiuc Kullanici 3 saniye bekler
         And USyirmiuc Doktor status u Completed olarak secer
         And USyirmiuc Doktor Save butonuna tiklar
         And USyirmiuc Kullanici 3 saniye bekler
         And USyirmiuc Status u Completed olarak degistigini dogrular
         And USyirmiuc sayfayi kapatir

@US023-2
Scenario: Personelin fatura olusturabilmesi icin statusunun personel tarafindan Cancelled olarak ayarlanmasi gerekir

               Given USyirmiuc Personel Medunna adresine gider
               When USyirmiuc Personel Sing in simgesine tiklar
              And USyirmiuc Personel Sing in e tiklar
              And USyirmiuc Personel Username girer
              And USyirmiuc Personel Password girer
              And USyirmiuc Personel Sing in butonuna tiklar
              And USyirmiuc Personel My Page sekmesine tiklar
              And USyirmiuc Personel My Page sekmesinde Search Patient sekmesine tiklar
              And USyirmiuc Personel Patient SSN searchbox a hastanin SSN numarasini girer
              And USyirmiuc Personel Show Appointments kutucugunu tiklar
              And USyirmiuc Personel Cencelled olacak rendevu icin Edit e tiklar
              And USyirmiuc Personel Status u Cancelled olarak ayarlar
              And USyirmiuc Personel Save buttonuna basar
              And USyirmiuc Status u Cancelled olarak degistigini dogrular
              And USyirmiuc Personel Patient SSN searchbox a hastanin SSN numarasini girer
              And USyirmiuc Personel Show Appointments kutucugunu tiklar
              And USyirmiuc Statusu Cancelled olan hastada Payment Invoice Process  olmadigini dogrula
              And USyirmiuc sayfayi kapatir

 @US023-3
  Scenario: Kullanıcı (Personel) Fatura Ödeme işlemine gidebilir/Kullanıcı daha sonra hastaya gönderilen faturayı görebilir

                 Given USyirmiuc Personel Medunna adresine gider
                 Then USyirmiuc Personel Sing in simgesine tiklar
                And USyirmiuc Personel Sing in e tiklar
                And USyirmiuc Personel Username girer
                And USyirmiuc Personel Password girer
                And USyirmiuc Personel Sing in butonuna tiklar
                And USyirmiuc Personel My Page sekmesine tiklar
                And USyirmiuc Personel My Page sekmesinde Search Patient sekmesine tiklar
                And USyirmiuc Personel Patient SSN searchbox a hastanin SSN numarasini girer
                And USyirmiuc Personel Show Appointments kutucugunu tiklar
                And USyirmiuc Statusu Completed olan hastada Payment Invoice Process i tiklar
                And USyirmiuc Personel Patment Detail i gorur
                And USyirmiuc Personel Show Invoice tiklar
                And USyirmiuc Personel hastaya gondereilen faturayi gorur
                And USyirmiuc sayfayi kapatir

    @US023-4
    Scenario: Personel hasta icin yeni bir fatura olusturabilir

                 Given USyirmiuc Personel Medunna adresine gider
                 When USyirmiuc Personel Sing in simgesine tiklar
                 And USyirmiuc Personel Sing in e tiklar
                 And USyirmiuc Personel Username girer
                 And USyirmiuc Personel Password girer
                 And USyirmiuc Personel Sing in butonuna tiklar
                 And USyirmiuc Personel My Page sekmesine tiklar
                 And USyirmiuc Personel My Page sekmesinde Search Patient sekmesine tiklar
                 And USyirmiuc Personel Patient SSN searchbox a hastanin SSN numarasini girer
                 And USyirmiuc Personel Show Appointments kutucugunu tiklar
                 And USyirmiuc Statusu Completed olan hastada icin Creat Invoice butonu olmadigini dogrular
                 And USyirmiuc sayfayi kapatir