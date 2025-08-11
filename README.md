# Проект по автоматизации тестовых сценариев для сайта [PiterGSM](https://pitergsm.ru/)

<p align="center">
  <a href="https://pitergsm.ru/" target="_blank">
    <img src="media/screens/Logo.png" width="200" alt="PiterGSM Logo">
  </a>
</p>

## :pushpin: Содержание:

- [Технологии и инструменты](#computer-технологии-и-инструменты)
- [Факты о проекте](#clipboard-факты-о-проекте)
- [Web-тесты](#-web-тесты)
- [API-тесты](#-api-тесты)
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
<code><a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/icons/AllureTestOps.svg"></a></code>
<code><a href="https://web.telegram.org/"><img width="5%" title="Telegram" src="media/icons/Telegram.svg"></a></code>
<code><a href="https://www.atlassian.com/software/jira"><img width="5%" title="Jira" src="media/icons/Jira.svg"></a></code>
</p>

Автотесты написаны на `Java` с использованием фреймворка `Selenide`.\
`Gradle` - сборщик проекта.  \
`JUnit5` - для выполнения тестов.\
`REST Assured` - для тестирования REST-API сервисов.\
`Jenkins` - CI/CD для запуска тестов удаленно.\
`Selenoid` - для удаленного запуска браузера.\
`Allure Report` - для визуализации результатов тестирования.\
`Telegram Bot` - для уведомлений о результатах тестирования.\
`Allure TestOps` - как система управления тестированием.

## :clipboard: Факты о проекте
- [x] Тестовый проект состоит из UI и API автотестов
- [x] `Page Object` проектирование UI-тестов
- [x] Различные файлы конфигурации для запуска теста в зависимости от параметров сборки
- [x] Конфигурация с библиотекой `Owner`
- [x] Использование `Lombok` для моделей в API тестах
- [x] Использование request/response спецификаций для API тестов
- [x] Custom Allure listener для API requests/responses логов
- [x] Интеграция с `Allure TestOps`
- [x] Автотесты как тестовая документация
- [x] Интеграция с `Jira`
