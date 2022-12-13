Feature: CE Kayıt olmak için SSN, First Name ve Last Name bilgileri girilebilmelidir

  @SmokeTest
  @UIKayit
  Scenario:kayit
    Given  CE kullanici register sayfasinda
    And CE kullanici ssn  girer
    And CE kullanici firstName ve lastName girer
    And CE kullanici usrname olarak girer
    And CE kullanici email olarak girer
    And CE kullanici firstpassword olarak girer
    And CE kullanici secondpassword girer
    Then CE register butonuna tiklar
    Then CE tum datayi okur