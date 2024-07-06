# PaperManagementSystem
Conference and paper management system. Sadece paper yükleme ve atama kısımları implemente edilmiştir.
Uygulamada kullanıcılar paperlarını dosya olarak yükleyip, paper hakkında gerekli bilgileri girebilmektedir.
Bu yüklenen paperlar inceleme ve onay işlemleri için farklı kullanıcılara atanmaktadır.
Onay işlemleri sonucunda paperlar sistemde herkesin erişimine açılıp okunabilmektedir.

Kullanıcıların reviewer, author vb. rolleri bulunmaktadır. Bu rollere göre farklı işlemler yapılabilmektedir. 
Ayrıca reviewer ve authorların matematik, fizik vb. gibi uzmanlık alanları da bulunmaktadır.
Authorlar paper yükleyebilmektedir. Yükledikleri paperlar onay süreci için uzmanlık alanına göre bir reviewera atanmaktadır.
Eğer onaylanmazsa tekrar inceleme talep edilebilmektedir. Onaylanırsa tüm kullanıcıların bu paperları inceleyebileceği bir anasayfada görüntülenebilmektedir.


**************************************************************************
Çalıştırmak için aşağıdaki adımları takip edebilirsiniz.

Projeyi çalıştırabilmek için Mysql database'in kurulu olması gerekmektedir.
Eğer database kurulu ise:
1) Proje içinde resources klasörü altında application.properties dosyasına gidiniz.
2) Burada myFilePath değişkenine yüklenen paper dosyalarının (pdf vs.) kaydedilmesini istediğiniz klasörünüzün dosya yolunu giriniz.
3) spring.datasource.username ve spring.datasource.password kısımlarına mysql databaseinizin isim ve şifresini giriniz.
4) sql_scripts klasörüne gidiniz.
5) tables.sql'deki sql kodlarını database schemasını ve tablolarını oluşturmak mysql'de için çalıştırın.
6) data.sql'deki sql kodlarını database'e örnek veri yüklemek için çalıştırın.
7) Artık uygulamayı çalıştırabilirsiniz. Tüm örnek kullanıcıların şifreleri ise 123
