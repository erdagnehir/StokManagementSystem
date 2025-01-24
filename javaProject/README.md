Projede Modülllerinin Tanıtımı

1) Ürün Modülü
   Yeni ürün eklenebilir.
   Eklenen ürünler listelenebilir.
   Eklenen ürünlerin bilgileri güncellenebilir.
   Her ürüne bir adet depo seçimi yapılabilmektedir.
   Ürün stokları, ürünler listesinden ürün güncelleme ile yapılabilmektedir.

2) Depo Modülü
   Yeni depo eklenebilir.
   Eklenen depolar listelenebilir.
   Eklenen depoların bilgileri güncellenebilir.
   Eğer seçilen depoda ürün yok ise depo silinebilmektedir.
   Bir depoda birden fazla ürün bulunabilir.

3) Sipariş Modülü
   Sipariş ekleme formunda, kayıtlı olan ürünler arasından ürün seçimi yapılabilir.
   Formda ürün seçimi sonrası, stoktaki durumu, formu kaydetmeden, anlık mesaj olarak gösterilmektedir.
   Sipariş formunda kayıt yapıldıktan sonra, girilen adet kadar, ürün tablosundaki stok miktarından düşmektedir.
   Sipariş oluşturulduktan sonra yapılabilen işlemler, siparişleri listeleme ve siparişi silmedir.  
   Oluşturulan siparişteki ürün adedi stoktaki miktarı geçiyorsa uyarı vermektedir.

4) Ana Sayfa

   Ana sayfadan her modüle erişim sağlanabilir.
   Her modülün listeleme sayfası bulunur.
   Listeleme sayfalarının sol üst köşesinde yeni kayıt ekleme butonu yer alır.
   Sol üst köşede bulunan ikon ile ana sayfaya dönülebilir.

Teknik Detaylar

Kullanılan Teknolojiler

  -Spring Boot Framework

  -Hibernate ve JPA

  -Thymeleaf

  -Bootstrap

  -Katmanlı Mimari(MVC)

Katmanlar

1. Entity Katmanı

  Veritabanı ile etkileşimde bulunan sınıflar bu katmandadır.

  Kullanılan Entity Sınıfları:

   Product: Ürün bilgileri, stok bilgisi ve ürünün bulunduğu depo.

   WareHouse: Depo bilgileri ve depo ile ilişkili ürünler.

   Order: Sipariş bilgileri ve sipariş edilen ürünlerin detayları.

2. Controller Katmanı

  Kullanıcı taleplerini işler ve uygun cevapları döner.

  Controller Sınıfları:

   ProductController

   WareHouseController

   OrderController

3. Service Katmanı

   İş mantığının bulunduğu katmandır.

   Kullanılan Servisler:

   Order Service
   
   Product Service
   
   WareHouse Service

4. Resources > Templates

   Kullanıcı etkileşimlerini işleyen dinamik HTML sayfaları bu dizindedir.

   Thymeleaf ve Bootstrap kullanılarak tasarlanmıştır.

Yapılandırma Dosyaları

1. application.properties

   Veritabanı bağlantı bilgileri ve sunucu konfigürasyonları içerir.

   Örnek:

   spring.datasource.url=jdbc:mysql://localhost:3306/javaprojectdb
   spring.datasource.username=root
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update

2. pom.xml

   Maven bağımlılıklarını ve proje ayarlarını tanımlar.

Kurulum ve Çalıştırma

   Projeyi klonlayın: git clone https://github.com/kullanici/proje-adi.git

Maven bağımlılıklarını yükleyin: mvn clean install

Uygulamayı başlatın: mvn spring-boot:run

Tarayıcıda şu adrese gidin: http://localhost:8080