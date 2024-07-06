INSERT INTO `conference_mng_db`.`role` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `conference_mng_db`.`role` (`name`) VALUES ('ROLE_ATTENDEE');
INSERT INTO `conference_mng_db`.`role` (`name`) VALUES ('ROLE_AUTHOR');
INSERT INTO `conference_mng_db`.`role` (`name`) VALUES ('ROLE_ORGANIZER');
INSERT INTO `conference_mng_db`.`role` (`name`) VALUES ('ROLE_PRESENTER');
INSERT INTO `conference_mng_db`.`role` (`name`) VALUES ('ROLE_REVIEWER');
INSERT INTO `conference_mng_db`.`role` (`name`) VALUES ('ROLE_USER');



INSERT INTO `conference_mng_db`.`profession` (`name`) VALUES ('Biyoloji');
INSERT INTO `conference_mng_db`.`profession` (`name`) VALUES ('Fizik');
INSERT INTO `conference_mng_db`.`profession` (`name`) VALUES ('Kimya');
INSERT INTO `conference_mng_db`.`profession` (`name`) VALUES ('Matematik');



INSERT INTO `conference_mng_db`.`user` (`id`, `name`, `surname`, `phone`, `age`, `mail`, `password`, `enabled`, `is_reviewer_enable_to_review`, `is_reviewer_has_not_assignment`) VALUES (1, 'Mehmet', 'Yılmaz', '55533312', 25, 'author1@gmail.com', '$2a$10$eVIiVJKfYVnpwiVswPP2Zefa4XwgdR8LQs0cFPs5EPIJzwf5UatIu', 1, 0, 0);
INSERT INTO `conference_mng_db`.`user` (`id`, `name`, `surname`, `phone`, `age`, `mail`, `password`, `enabled`, `is_reviewer_enable_to_review`, `is_reviewer_has_not_assignment`) VALUES (2, 'Ayşe', 'Kaya', '55544423', 30, 'author2@gmail.com', '$2a$10$eVIiVJKfYVnpwiVswPP2Zefa4XwgdR8LQs0cFPs5EPIJzwf5UatIu', 1, 0, 0);
INSERT INTO `conference_mng_db`.`user` (`id`, `name`, `surname`, `phone`, `age`, `mail`, `password`, `enabled`, `is_reviewer_enable_to_review`, `is_reviewer_has_not_assignment`) VALUES (3, 'Ali', 'Demir', '55577745', 28, 'reviewer3@gmail.com', '$2a$10$eVIiVJKfYVnpwiVswPP2Zefa4XwgdR8LQs0cFPs5EPIJzwf5UatIu', 1, 1, 1);
INSERT INTO `conference_mng_db`.`user` (`id`, `name`, `surname`, `phone`, `age`, `mail`, `password`, `enabled`, `is_reviewer_enable_to_review`, `is_reviewer_has_not_assignment`) VALUES (4, 'Fatma', 'Şahin', '55599987', 35, 'reviewer4@gmail.com', '$2a$10$eVIiVJKfYVnpwiVswPP2Zefa4XwgdR8LQs0cFPs5EPIJzwf5UatIu', 1, 1, 0);
INSERT INTO `conference_mng_db`.`user` (`id`, `name`, `surname`, `phone`, `age`, `mail`, `password`, `enabled`, `is_reviewer_enable_to_review`, `is_reviewer_has_not_assignment`) VALUES (5, 'Ahmet', 'Yıldırım', '55511123', 27, 'reviewer5@gmail.com', '$2a$10$eVIiVJKfYVnpwiVswPP2Zefa4XwgdR8LQs0cFPs5EPIJzwf5UatIu.', 1, 1, 0);
INSERT INTO `conference_mng_db`.`user` (`id`, `name`, `surname`, `phone`, `age`, `mail`, `password`, `enabled`, `is_reviewer_enable_to_review`, `is_reviewer_has_not_assignment`) VALUES (6, 'Ayşegül', 'Can', '55588812', 32, 'reviewer6@gmail.com', '$2a$10$eVIiVJKfYVnpwiVswPP2Zefa4XwgdR8LQs0cFPs5EPIJzwf5UatIu', 1, 1, 0);



INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (1,'ROLE_USER');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (2,'ROLE_USER');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (3,'ROLE_USER');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (4,'ROLE_USER');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (5,'ROLE_USER');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (6,'ROLE_USER');

INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (1,'ROLE_AUTHOR');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (2,'ROLE_AUTHOR');

INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (3,'ROLE_REVIEWER');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (4,'ROLE_REVIEWER');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (5,'ROLE_REVIEWER');
INSERT INTO `conference_mng_db`.`users_roles` (`user_id`,`role_name`) VALUES (6,'ROLE_REVIEWER');



INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('1', 'Biyoloji');
INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('1', 'Kimya');

INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('2', 'Fizik');
INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('2', 'Matematik');

INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('3', 'Matematik');

INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('4', 'Fizik');
INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('4', 'Biyoloji');

INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('5', 'Kimya');
INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('5', 'Biyoloji');

INSERT INTO `conference_mng_db`.`users_professions` (`user_id`, `profession_name`) VALUES ('6', 'Biyoloji');



INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (1,'2024-05-12','Kuantum Fiziğinde Parçacık Davranışının İncelenmesi','Sonuçlandı.','Fizik','Kuantum fiziği, madde ve enerjinin mikroskobik düzeydeki davranışlarını inceleyen oldukça karmaşık bir alan olup, fizik dünyasının en heyecan verici ve sıra dışı konularından birini oluşturur. Bu makalede, kuantum mekaniğinin temel prensiplerinden biri olan parçacık dalga fonksiyonu üzerine yoğunlaşılmaktadır. Parçacık dalga fonksiyonu, bir parçacığın davranışını tanımlayan matematiksel bir ifade olarak kabul edilir ve parçacığın bir yerde bulunma olasılığını belirtir. Ancak, bu kavramın temelinde yatan felsefi ve ontolojik sorular, kuantum mekaniğinin anlaşılmasını oldukça karmaşık hale getirir. Makalede, parçacık davranışının dalga-paketleme fenomeniyle nasıl ilişkilendirildiği ve deneysel olarak nasıl doğrulandığı detaylı bir şekilde incelenmektedir. Dalga-paketleme, bir parçacığın aynı anda hem dalga hem de parçacık özelliklerine sahip olabileceği fikrini ortaya koyar ve kuantum mekaniğinin temel paradokslarından birini oluşturur. Deneyler ve gözlemler, parçacık davranışının gerçekten harika.',2);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (2,'2024-05-12','Biyolojik Çeşitlilikteki Değişimlerin İklim Değişikliği ile İlişkisi','Sonuçlandı.','Biyoloji','İklim değişikliği, gezegenimiz üzerindeki etkileriyle giderek daha fazla endişe yaratmaktadır ve bu, birçok bilim insanı ve çevre uzmanı tarafından ciddi bir tehdit olarak kabul edilmektedir. Bu makalede, iklim değişikliğinin biyolojik çeşitlilik üzerindeki potansiyel etkileri detaylı bir şekilde incelenmektedir. Özellikle, habitat değişikliklerinin türlerin dağılımı, popülasyon dinamikleri ve ekosistem fonksiyonları üzerindeki etkileri ele alınmaktadır. İklim değişikliğinin neden olduğu sıcaklık artışı, yağış değişiklikleri ve ekstrem hava olayları gibi faktörler, birçok tür için uygun olmayan yaşam alanlarına ve koşullara neden olmaktadır. Bu durum, türlerin göç etmesine, habitatlarını değiştirmesine ve adaptasyon stratejilerini geliştirmesine neden olmaktadır. Bunun yanı sıra, iklim değişikliği aynı zamanda bazı türler için yok olma riskini de artırmaktadır. Bu makalede sunulan sonuçlar, iklim değişikliğinin biyolojik çeşitlilik üzerindeki etkilerinin derinlemesine anlaşılması ve biyolojik çeşitliliği koruma stratejilerinin geliştirilmesi gerekliliğini vurgulamaktadır.',1);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (3,'2024-05-12','Matematiksel Analizde Yeni Bir Yaklaşım: Fraktalların Kullanımı','Sonuçlandı.','Matematik','Fraktallar, matematiksel analizde son yıllarda giderek daha fazla önem kazanan ve ilgi çeken bir konu haline gelmiştir. Klasik geometrinin düz çizgileri ve düzlemleri dışında, fraktal geometri karmaşık ve tekrarlanan desenlerin incelenmesini sağlar. Bu makalede, fraktal geometrinin klasik matematiksel analiz yöntemlerinden farklı olarak nasıl bir perspektif sunduğu detaylı bir şekilde araştırılmaktadır. Fraktallar, kendine benzerliğin ve ölçek bağımsızlığın özelliklerini sergileyen matematiksel nesnelerdir. Bu özellikleri sayesinde, doğal süreçlerin, karmaşık sistemlerin ve düzensiz desenlerin modellemesinde kullanılabilmektedirler. Makalede özellikle fraktal boyut kavramı ve fraktal setlerin özellikleri üzerinde yoğunlaşılmıştır. Fraktal boyut, geleneksel boyut kavramından farklı olarak, bir fraktal yapının kendine benzerliğinin derecesini ölçer.',2);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (4,'2024-05-12','Protein Katlanma Probleminde Yapay Zeka Destekli Yöntemler','Atama Bekliyor.','Biyoloji','Protein katlanma, biyolojik sistemlerin temel bir özelliği olup, hücresel işlevlerden metabolik süreçlere kadar birçok biyolojik olayın temelini oluşturur. Bu karmaşık fenomen, uzun süredir birçok araştırmacının odak noktası olmuştur ve hala tam olarak anlaşılamamış birçok yönü bulunmaktadır. Bu makalede, protein katlanma probleminin çözümünde yapay zeka tekniklerinin nasıl kullanılabileceği araştırılmaktadır. Özellikle, derin öğrenme ve genetik algoritmaların protein katlanma modellemesi üzerindeki etkileri ve potansiyel uygulama alanları detaylı bir şekilde incelenmektedir. Derin öğrenme teknikleri, büyük miktarda veri ile eğitilen yapay sinir ağlarını içerir ve protein katlanma probleminin karmaşıklığını anlamak ve öngörmek için güçlü bir araç olabilir. Genetik algoritmalar ise protein yapılarını optimize etmek ve enerji minimumuna ulaşmak için kullanılabilir.',1);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (5,'2024-05-12','Kimyasal Reaksiyon Kinetiği Modellenmesinde Yeni Bir Yaklaşım','Sonuçlandı.','Kimya','Kimyasal reaksiyon kinetiği, bir reaksiyonun hızını, mekanizmasını ve faktörlerini inceleyen önemli bir alan olup, endüstriyel süreçlerden biyokimyasal reaksiyonlara kadar birçok alanda kullanılmaktadır. Bu makalede, geleneksel kinetik modellemeye alternatif bir yaklaşım önerilmektedir ve kimyasal reaksiyon kinetiğinin yeniden değerlendirilmesi ve genişletilmesi üzerine odaklanmaktadır. Özellikle, stokiyometrik denge dışı sistemlerin modellenmesinde termodinamik ilkelerin nasıl kullanılabileceği araştırılmaktadır. Bu yeni yaklaşım, kimyasal reaksiyonların karmaşıklığını daha iyi anlamak ve kontrol etmek için bir çerçeve sunmaktadır. Makalede, termodinamik ilkelerin kinetik modellere nasıl entegre edilebileceği ve reaksiyon sistemlerinin dinamiklerinin nasıl analiz edilebileceği detaylı bir şekilde ele alınmaktadır. Ayrıca, yeni yaklaşımın pratikteki uygulanabilirliği ve mevcut modellerle karşılaştırılması da sunulmaktadır. Bu çalışmanın, kimyasal mühendislik, malzeme bilimi ve biyokimya gibi alanlardaki araştırmacılar ve endüstri profesyonelleri için önemli bir referans kaynağı olması beklenmektedir.',1);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (6,'2024-05-12','Rölativite Teorisinin Uygulamaları: GPS Navigasyon Sistemlerindeki Rolü','Bir Reviewera Atandı.','Fizik','Albert Einstein\'ın geliştirdiği görelilik teorisi, modern fizik ve mühendislik alanlarında dönüştürücü bir etkiye sahiptir. Bu makalede, özellikle GPS navigasyon sistemlerindeki pratik uygulamaları incelenmektedir. Görelilik teorisinin, zaman dilasyonu ve uzay eğriliği gibi temel kavramlarının, günümüzde hassas zaman senkronizasyonu ve konum belirleme sistemlerinde nasıl kullanıldığı ve hesaba katıldığı detaylı bir şekilde açıklanmaktadır. GPS navigasyon sistemleri, uzayda dolaşan uydu ağlarından alınan sinyalleri kullanarak kullanıcıların konumunu belirler. Ancak, bu sinyallerin hareketli bir gözlemci tarafından algılanması, Einstein\'ın görelilik teorisinde öne sürdüğü zamanın göreli doğası nedeniyle zaman dilasyonuna yol açar. Bu nedenle, GPS alıcıları ve uydu saatleri arasındaki senkronizasyonu sağlamak için görelilik etkileri dikkate alınmalıdır. Ayrıca, uzaydaki gravitasyonel alanlar da zamanın akışını etkiler ve bu da zaman dilasyonunun bir başka kaynağıdır.',2);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (7,'2024-05-12','Moleküler Biyolojide Yeni Gelişmeler: CRISPR-Cas9 Teknolojisi','Bir Reviewera Atandı.','Biyoloji','Moleküler biyoloji, genetik mühendisliği ve tıbbi araştırmalar gibi birçok alanda önemli bir rol oynamaktadır ve bu alanlardaki gelişmeler, bilim ve teknolojinin ilerlemesine önemli katkılar sağlamaktadır. Bu makalede, özellikle CRISPR-Cas9 teknolojisinin moleküler biyoloji alanındaki son gelişmeleri ve etkileri detaylı bir şekilde incelenmektedir. CRISPR-Cas9, son yıllarda gen düzenleme ve genetik manipülasyon alanlarında devrim niteliğinde bir teknoloji olarak kabul edilmektedir. Bu teknoloji, hızlı, hassas ve maliyet etkin bir şekilde DNA\'yı kesme ve değiştirme yeteneğine sahiptir. Makalede, CRISPR-Cas9\'un gen düzenleme üzerindeki etkileri, genetik hastalıkların tedavisi, tarımsal biyoteknoloji ve biyotıpta kullanımı gibi çeşitli uygulama alanları ele alınmaktadır. Ayrıca, CRISPR-Cas9 teknolojisinin gelecekteki potansiyel uygulamaları ve etik sorunları da tartışılmaktadır. Bu teknolojinin yaygın olarak benimsenmesi ve uygulanması, moleküler biyoloji ve genetik alanındaki araştırmalarda önemli bir dönüm noktası olabilir. Sunulan sonuçlar, CRISPR-Cas9 teknolojisinin gelecekteki uygulama alanlarını ve potansiyel etkilerini anlamak için önemli bir kaynak olarak hizmet edebilir.',1);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (8,'2024-05-12','Topolojik Yarı İletkenlerin Elektronik Uygulamalardaki Potansiyeli','Atama Bekliyor.','Fizik','Topolojik yarı iletkenler, son yıllarda elektroniğin geleceğinde önemli bir rol oynaması beklenen yeni ve heyecan verici bir malzeme sınıfı olarak dikkat çekmektedir. Bu makalede, topolojik yarı iletkenlerin temel özellikleri ve elektronik uygulamalardaki potansiyeli detaylı bir şekilde incelenmektedir. Topolojik yarı iletkenler, geleneksel yarı iletkenlerden farklı olarak, elektronların spin özelliklerine bağlı olarak davranış gösterirler. Bu özellikleri sayesinde, spintronik ve kuantum bilgisayarlar gibi alanlarda yeni ve yenilikçi uygulamalara olanak sağlarlar. Özellikle, topolojik yarı iletkenlerin spintronik cihazlarda kullanılması, veri depolama, veri işleme ve manyetik sensörler gibi birçok alanda devrim niteliğinde ilerlemelere yol açabilir. Ayrıca, kuantum bilgisayarlar için kilit bir bileşen olarak da görülmektedirler.',2);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (9,'2024-05-12','Mikrobiyal Biyofilm Oluşumunun Su Temizleme Teknolojilerindeki Rolü','Sonuçlandı.','Biyoloji','Mikrobiyal biyofilm oluşumu, doğal yaşamın yanı sıra endüstriyel süreçlerde de önemli bir fenomen olarak öne çıkmaktadır. Bu makalede, mikrobiyal biyofilm oluşumunun su temizleme teknolojilerindeki rolü ve etkileri detaylı bir şekilde incelenmektedir. Özellikle, biyofilm tabanlı arıtma yöntemlerinin etkinliği ve çevresel etkileri üzerinde durulmaktadır. Biyofilm tabanlı arıtma yöntemleri, su kaynaklarının temizlenmesi ve arıtılması için etkili ve sürdürülebilir çözümler sunmaktadır. Bu yöntemler, geleneksel arıtma sistemlerine kıyasla daha düşük maliyetli ve daha az enerji tüketen alternatifler olarak öne çıkmaktadır. Sunulan sonuçlar, mikrobiyal biyofilm teknolojilerinin gelecekte su kaynakları yönetiminde önemli bir rol oynayabileceğini ve su temizleme endüstrisinde önemli bir yer edinebileceğini göstermektedir. Bu bilgilerin, su temizleme teknolojileri üzerine çalışan araştırmacılar, mühendisler ve endüstri uzmanları için önemli bir kaynak olacağı düşünülmektedir.',1);
INSERT INTO `conference_mng_db`.`paper` (`id`,`upload_date`,`title`,`state`,`field`,`summary`,`author_id`) VALUES (10,'2024-05-12','İnorganik Kimyada Yeni Sentez Yöntemleri ve Uygulamaları','Revize Bekleniyor.','Kimya','İnorganik kimya, malzeme bilimi, ilaç geliştirme ve kataliz gibi geniş bir yelpazede önemli uygulamalara sahip çok yönlü bir disiplindir. Bu makalede, inorganik kimyanın bu çeşitli alanlardaki etkileyici uygulamaları ve gelecek vaat eden potansiyeli incelenmektedir. Özellikle, inorganik kimyada yeni sentez yöntemleri ve bu yöntemlerin çeşitli uygulama alanları ele alınmaktadır. Nano malzemelerin sentezi, metal organik çerçeveler ve benzeri ileri düzey malzemelerin geliştirilmesindeki son teknolojik gelişmeler ve buluşlar üzerinde durulmaktadır. Bu çalışmada sunulan sonuçlar, inorganik kimyanın yenilikçi sentez stratejilerinin ve malzeme tasarımının gelecekteki teknolojik ilerlemelere nasıl önemli katkılar sağlayabileceğini göstermektedir. Bu bilgilerin, inorganik kimya alanındaki araştırmacılar, endüstri uzmanları ve ilgili diğer paydaşlar için önemli bir referans kaynağı olacağına inanılmaktadır.',1);




INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (1,1,'quantummechanicsource.com');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (2,1,'particlebehaviorjournal.org');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (3,2,'biodiversityclimatechange.com');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (4,2,'habitatshiftsresearch.org');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (5,3,'mathematicalmodelingjournal.org');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (6,4,'artificialintelligencebiotech.org');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (7,5,'chemicalkineticsource.com');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (8,6,'spacetimeapplications.net');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (9,7,'crisprbiotechsource.com');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (10,7,'molecularbiologyadvances.org');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (11,7,'geneticengineeringjournal.net');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (12,8,'topologicalsemiconductor.com');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (13,9,'microbialbiofilmsource.com');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (14,9,'environmentalimpactstudies.net');
INSERT INTO `conference_mng_db`.`paper_source` (`id`,`paper_id`,`source`) VALUES (15,10,'nanomaterialsresearch.org');



INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (1,1,'Kuantum Fiziği');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (2,1,'Parçacık Davranışı');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (3,2,'Biyolojik Çeşitlilik');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (4,2,'İklim Değişikliği');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (5,2,'Habitat Değişiklikleri');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (6,3,'Matematiksel Analiz');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (7,3,'Fraktallar');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (8,3,'Geometri');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (9,3,'Matematiksel Modelleme');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (10,4,'Protein Katlanma');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (11,4,'Yapay Zeka');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (12,5,'Kimyasal Reaksiyon Kinetiği');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (13,5,'Termodinamik');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (14,6,'Rölativite Teorisi');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (15,7,'CRISPR-Cas9');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (16,7,'Moleküler Biyoloji');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (17,7,'Gen Düzenleme');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (18,8,'Topolojik Yarı İletkenler');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (19,8,'Elektronik Uygulamalar');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (20,9,'Mikrobiyal Biyofilm');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (21,9,'Su Temizleme');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (22,10,'İnorganik Kimya');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (23,10,'Nano Malzemeler');
INSERT INTO `conference_mng_db`.`paper_keyword` (`id`,`paper_id`,`keyword`) VALUES (24,10,'Malzeme Tasarımı');



INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (1,1,'pdf_dosyası.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (2,1,'powerpoint_sunumu.pptx');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (3,2,'pdf_dosyası.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (4,3,'pdf_dosyası.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (5,4,'pdf_dosyası2.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (6,5,'powerpoint_sunumu.pptx');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (7,5,'pdf_dosyası2.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (8,6,'pdf_dosyası.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (9,7,'pdf_dosyası.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (10,7,'powerpoint_sunumu.pptx');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (11,8,'pdf_dosyası2.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (12,9,'pdf_dosyası.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (13,9,'powerpoint_sunumu.pptx');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (14,9,'pdf_dosyası2.pdf');
INSERT INTO `conference_mng_db`.`paper_file` (`id`,`paper_id`,`file_location`) VALUES (15,10,'pdf_dosyası.pdf');



INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (1,10,5,'2024-05-12',70,'Revizyon.','Revize bekleniyor.','2024-05-12','Merhaba, incelediğim makalenin genelinde güçlü bir yapı fark ettim. Ancak, bazı noktalarda daha derinlemesine açıklama veya düzeltme gerekebilir. Özet bölümünde, çalışmanın ana noktalarının daha net ve özlü bir şekilde sunulması önemlidir.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (2,2,6,'2024-05-12',30,'Reddedildi.','Tamamlandı.','2024-05-12','İncelemiş olduğumuz makalenizde, biyolojik çeşitlilikteki değişimler ile iklim değişikliği arasındaki ilişkiyi ele alan değerli çalışmanız için teşekkür ederiz. Ancak, maalesef, makalenizin yayına uygun olmadığına karar verilmiştir. Reddedilme nedenleri aşağıda belirtilmiştir: Makalenin kapsamı, biyolojik çeşitlilikteki değişimlerin iklim değişikliği ile ilişkisini ele almaktadır. Ancak, bu ilişkiyi daha kapsamlı bir şekilde ele almak ve sonuçları daha geniş bir bağlama oturtmak gerekmektedir.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (3,2,4,'2024-05-12',40,'Reddedildi.','Tamamlandı.','2024-05-12','İncelemiş olduğumuz makalenizde, biyolojik çeşitlilikteki değişimler ile iklim değişikliği arasındaki ilişkiyi ele alan değerli çalışmanız için teşekkür ederiz. Ancak, maalesef, makalenizin yayına uygun olmadığına karar verilmiştir. Reddedilme nedenleri aşağıda belirtilmiştir: Makalenin kapsamı, biyolojik çeşitlilikteki değişimlerin iklim değişikliği ile ilişkisini ele almaktadır. Ancak, bu ilişkiyi daha kapsamlı bir şekilde ele almak ve sonuçları daha geniş bir bağlama oturtmak gerekmektedir.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (4,2,5,'2024-05-12',35,'Reddedildi.','Tamamlandı.','2024-05-12','İncelemiş olduğumuz makalenizde, biyolojik çeşitlilikteki değişimler ile iklim değişikliği arasındaki ilişkiyi ele alan değerli çalışmanız için teşekkür ederiz. Ancak, maalesef, makalenizin yayına uygun olmadığına karar verilmiştir. Reddedilme nedenleri aşağıda belirtilmiştir: Makalenin kapsamı, biyolojik çeşitlilikteki değişimlerin iklim değişikliği ile ilişkisini ele almaktadır. Ancak, bu ilişkiyi daha kapsamlı bir şekilde ele almak ve sonuçları daha geniş bir bağlama oturtmak gerekmektedir.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (5,9,4,'2024-05-12',65,'Reddedildi.','Tamamlandı.','2024-05-12','Makalenizi dikkatle inceledik. Ancak, ne yazık ki, yayın standartlarımıza uygun bulunmadığı için makalenizin kabul edilmesi mümkün olmamıştır. Çalışmanızın bazı noktalarda eksiklikleri bulunmaktadır ve daha fazla geliştirilmesi gerekmektedir. Bu eksikliklerin giderilmesi durumunda, gelecekteki başvurularınızı değerlendirmekten memnuniyet duyacağız.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (6,9,6,'2024-05-12',85,'Onaylandı.','Tamamlandı.','2024-05-12','Makalenizi dikkatle inceledik ve büyük bir memnuniyetle bildirmek isteriz ki, çalışmanız yayın standartlarımıza uygun bulunmuş ve kabul edilmiştir. Makalenizin kalitesi ve önemi için teşekkür ederiz. Yayına alındığı için sizleri tebrik ederiz.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (7,1,4,'2024-05-12',100,'Onaylandı.','Tamamlandı.','2024-05-12','Makalenizi dikkatle inceledik ve büyük bir memnuniyetle bildirmek isteriz ki, çalışmanız yayın standartlarımıza uygun bulunmuş ve kabul edilmiştir. Makalenizin kalitesi ve önemi için teşekkür ederiz. Yayına alındığı için sizleri tebrik ederiz.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (8,3,3,'2024-05-12',90,'Onaylandı.','Tamamlandı.','2024-05-12','Makalenizi dikkatle inceledik ve büyük bir memnuniyetle bildirmek isteriz ki, çalışmanız yayın standartlarımıza uygun bulunmuş ve kabul edilmiştir. Makalenizin kalitesi ve önemi için teşekkür ederiz. Yayına alındığı için sizleri tebrik ederiz.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (9,5,5,'2024-05-12',20,'Reddedildi.','Tamamlandı.','2024-05-12','Makalenizi dikkatle inceledik. Ancak, ne yazık ki, yayın standartlarımıza uygun bulunmadığı için makalenizin kabul edilmesi mümkün olmamıştır. Çalışmanızın bazı noktalarda eksiklikleri bulunmaktadır ve daha fazla geliştirilmesi gerekmektedir. Bu eksikliklerin giderilmesi durumunda, gelecekteki başvurularınızı değerlendirmekten memnuniyet duyacağız.');
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (10,6,4,'2024-05-12',0,NULL,'İncele aşamasında.',NULL,NULL);
INSERT INTO `conference_mng_db`.`paper_assignment` (`id`,`paper_id`,`reviewer_id`,`assignment_date`,`score`,`result`,`state`,`return_date`,`feedback`) VALUES (11,7,6,'2024-05-12',0,NULL,'İncele aşamasında.',NULL,NULL);
