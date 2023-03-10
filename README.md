# sax_vs_dom_in_java
Что работает быстрее: SAX (simple api for xml) или DOM (document object model)? 

Рефлексия делает код более читабельным и упрощает жизнь разработчику: не нужно писать кучу if. Из минусов, как можно понять, - нарушение одного из принципов ООП - инкапсуляции (конкретно в коде меняется значение приватной переменной вне класса); достаточная медлительность.
DOM предоставляет большой спектр функций для разных случаев, им удобно пользоваться в сложных xml (например, с "гнездовыми"(nested) элементами), однако, он очень долго парсит при больших данных (>5MB).
Простой парсинг SAX работает быстрее всех, скорее всего, в силу своей простоты. Конечно, если размер xml небольшой (<256KB), то разница с другими парсерами не такая заметная, что заставляет задуматься об его использовании.
<br/>
<br/>
<br/>
![image](https://user-images.githubusercontent.com/97818959/218316452-dd9c0430-4543-45e9-acdc-e12ca7d5f909.png)
<br/>
На фотографии выше видно, что простой парсер SAX делает свою работу быстрее всех. От 252KB до 1MB хуже всех показывает себя SAX с рефлексией. И, наконец, от 5MB DOM занимает последнее место по времени.
<br/>
<br/>
<br/>
![image](https://user-images.githubusercontent.com/97818959/218316476-491d2f73-5d42-41fc-9299-d97b9a83e836.png)
<br/>
График на основе таблицы вычислений
