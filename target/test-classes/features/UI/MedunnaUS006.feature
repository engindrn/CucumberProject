@US006
Feature:US006 Kullanıcı bilgisi sekmesi (Setting) Ana Sayfada düzenlenebilir olmalıdır.

  Background:ortak adimlar
    Given US06 Kullanici Medunna adresine gider
    When US06 Kullanici 2 saniye bekler
    Then US06 Kullanici Sing in simgesine tiklar
    When US06 Kullanici 2 saniye bekler
    Then US06 Kullanici Sing in e tiklar
    When US06 Kullanici 2 saniye bekler
    When US06 Kullanici "Username" girer
    When US06 Kullanici 2 saniye bekler
    Then US06 Kullanici password "Password" girer
    When US06 Kullanici 2 saniye bekler
    And US06 Kullanici Sing in butonuna tiklar
    When US06 Kullanici 2 saniye bekler
    And US06 Kullanici account-menu (Efe Efe) tiklar
    When US06 Kullanici 2 saniye bekler
    Then US06 Kullanici Settings i tiklar

  Scenario:TC001 Kullanıcı bilgileri "firstname, lastname, email" girerken doldurulan kullanıcı bilgileri olmalıdır.

    Given US06 User settings sayfasinda oldugunu dogrular
    Then US06 Firstname kayit olurken girilen firstname ile ayni olmalidir
    And US06 Lastname kayit olurken girilen lastname ile ayni olmalidir
    Then US06 Email kayit olurken girilen email ile ayni olmalidir
    And US06 Sayfayi kapatir

  Scenario:TC002 "Firstname"güncelleme seçeneği olmalıdır.

    Given US06 Kullanici yeni bir firstname girer
    And US06 Kullanici 2 saniye bekler
    When US06 Kullanici save butonuna tiklar
    And US06 Kullanici 3 saniye bekler
    Then US06 Firstname nin guncellendigini dogrular
    And US06 Sayfayi kapatir


  Scenario:TC003 "Lastname" güncelleme seçeneği olmalıdır.

    Given US06 Kullanici yeni bir lastname girer
    And US06 Kullanici 2 saniye bekler
    Then US06 Kullanici save butonuna tiklar
    And US06 Kullanici 3 saniye bekler
    And US06 Lastname nin guncellendigini dogrular
    And US06 Sayfayi kapatir

  Scenario:TC004 "E-mail" güncelleme seçeneği olmalıdır.

    Given US06 Kullanici yeni bir Email girer
    And US06 Kullanici 2 saniye bekler
    Then US06 Kullanici save butonuna tiklar
    And US06 Kullanici 2 saniye bekler
    And US06 Email in guncellendigini dogrular
  #   And Sayfayi kapatir                        bilgileri ilk haline getir tc1 icin