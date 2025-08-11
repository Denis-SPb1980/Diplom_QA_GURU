# Проект по автоматизации тестовых сценариев для сайта [PiterGSM](https://pitergsm.ru/)

<p align="center">
  <a href="https://pitergsm.ru/" target="_blank">
    <img src="media/screens/Logo.png" width="200" alt="PiterGSM Logo">
  </a>
</p>

## :pushpin: Содержание:

- [Технологии и инструменты](#computer-технологии-и-инструменты)
- [Факты о проекте](#clipboard-факты-о-проекте)
- [Web-тесты](#heavy_check_mark-web-тесты)
- [Команды для запуска из терминала](#arrow_forward-команды-для-запуска-из-терминала)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#clapper-видео-примера-запуска-тестов-в-selenoid)


## :computer: Технологии и инструменты

<p align="center">
<code><a href="https://www.jetbrains.com/idea/"><img width="5%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.svg"></a></code>
<code><a href="https://www.java.com/"><img width="5%" title="Java" src="media/icons/Java.svg"></a></code>
<code><a href="https://gradle.org/"><img width="5%" title="Gradle" src="media/icons/Gradle.svg"></a></code>
<code><a href="https://junit.org/junit5/"><img width="5%" title="JUnit5" src="media/icons/JUnit5.svg"></a></code>
<code><a href="https://selenide.org/"><img width="5%" title="Selenide" src="media/icons/Selenide.svg"></a></code>
<code><a href="https://aerokube.com/selenoid/"><img width="5%" title="Selenoid" src="media/icons/Selenoid.svg"></a></code>
<code><a href="https://rest-assured.io/"><img width="5%" title="REST-Assured" src="media/icons/RestAssured.svg"></a></code>
<code><a href="https://github.com/"><img width="5%" title="GitHub" src="media/icons/GitHub.svg"></a></code>
<code><a href="https://www.jenkins.io/"><img width="5%" title="Jenkins" src="media/icons/Jenkins.svg"></a></code>
<code><a href="https://github.com/allure-framework/allure2"><img width="5%" title="Allure Report" src="media/icons/Allure_Report.svg"></a></code>
<code><a href="https://web.telegram.org/"><img width="5%" title="Telegram" src="media/icons/Telegram.svg"></a></code>
</p>

Автотесты написаны на `Java` с использованием фреймворка `Selenide`.\
`Gradle` - сборщик проекта.  \
`JUnit5` - для выполнения тестов.\
`REST Assured` - для тестирования REST-API сервисов.\
`Jenkins` - CI/CD для запуска тестов удаленно.\
`Selenoid` - для удаленного запуска браузера.\
`Allure Report` - для визуализации результатов тестирования.\
`Telegram Bot` - для уведомлений о результатах тестирования.\

## :clipboard: Факты о проекте
- [x] Тестовый проект состоит из UI и API автотестов
- [x] `Page Object` проектирование UI-тестов
- [x] Различные файлы конфигурации для запуска теста в зависимости от параметров сборки
- [x] Конфигурация с библиотекой `Owner`
- [x] Использование `Lombok` для моделей в API тестах
- [x] Использование request/response спецификаций для API тестов
- [x] Custom Allure listener для API requests/responses логов
- [x] Автотесты как тестовая документация


## :heavy_check_mark: Web-тесты
- :white_check_mark: Авторизация и регистрация
    - :heavy_check_mark: Успешная авторизация по почте и паролю
    - :heavy_check_mark: Успешная регистрация с заполнением всех полей
    - :heavy_check_mark: Ошибка регистрации при непрохождении капчи
- :white_check_mark: Товары
    - :heavy_check_mark: Успешный поиск продукта
    - :heavy_check_mark: Успешное добавление товара в корзину
    - :heavy_check_mark: Успешное оформление заказа
    - :heavy_check_mark: Успешное удаление товара из корзины
    - :heavy_check_mark: Успешное добавление товара в избранное
    - :heavy_check_mark: Успешное оформление заказа с фильтрами
 
## :arrow_forward: Команды для запуска из терминала

### *Локальный запуск:*
#### *Web-тесты*
```
gradle clean web_test
```
#### *API-тесты*
```
gradle clean api_test
```
### *Удалённый запуск через Jenkins:*
```
clean ${TASK} 
"-Denv=remote"
"-Dremote.url=${SELENOID_URL}" 
"-Dremote.login=${SELENOID_LOGIN}" 
"-Dremote.password=${SELENOID_PASSWORD}" 
"-Dbrowser=${BROWSER}" 
"-Dbrowser.version=${BROWSER_VERSION}"
"-Dbrowser.size=${BROWSER_SIZE}"
```
### *Параметры сборки:*

* <code>TASK</code> – задача для запуска.
* <code>SELENOID_URL</code>, <code>SELENOID_LOGIN</code>, <code>SELENOID_PASSWORD</code> - необходимы для для удаленного запуска браузера.
* <code>BROWSER</code> - браузер, в котором будут выполняться тесты.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты.

## <img src="media/icons/Jenkins.svg" title="Jenkins" width="4%"/> <a href="https://jenkins.autotests.cloud/job/qa-guru-035-dp-pitergsm//">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Build" src="media/screens/Jenkins.png">
</p>




## <img src="media/icons/Allure_Report.svg" title="Allure Report" width="4%"/> <a href="https://jenkins.autotests.cloud/job/qa-guru-035-dp-pitergsm/29/allure">Пример Allure-отчета</a>
### *Главная страница Allure-отчета*

<p align="center">
<img title="Allure Overview" src="media/screens/AllureReport.png">
</p>




## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки бот в <code>Telegram</code> автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram bot" src="media/screens/tg_notification.png">
</p>



## :clapper: Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/Video.gif">
</p>
