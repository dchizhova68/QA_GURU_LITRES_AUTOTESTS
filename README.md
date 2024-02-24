# Проект по автоматизации тестирования для сервиса электронных и аудиокниг [Литрес](https://www.litres.ru/)

<img alt="litres" src="src/media/screenshots/mainPageLitres.JPG">

## :scroll: Содержание:
* <a href="#tools">Используемый стек</a>
* <a href="#cases">Примеры автоматизированных тест-кейсов</a>
* <a href="#console">Запуск из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Allure отчет</a>
* <a href="#allure-testops">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#telegram">Уведомление в Telegram при помощи бота</a>
* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>


<a id="tools"></a>
## :computer:<a name="Используемый стек">**Используемый стек:**</a>

<p align="center">
<a href="https://www.java.com/"><img width="6%" title="Java" src="src/media/logo/Java.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="src/media/logo/Selenide.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="src/media/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="src/media/logo/Junit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="src/media/logo/GitHub.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="src/media/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="src/media/logo/Allure.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="src/media/logo/Allure_TO.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="src/media/logo/Jenkins.svg"></a>
<a href="https://web.telegram.org/a/"><img width="6%" title="Telegram" src="src/media/logo/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="src/media/logo/Jira.svg"></a>
</p>


<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>

- ✓ *Проверка поиска книг*
- ✓ *Проверка добавления книг и удаление книг из корзины*
- ✓ *Проверка элементов навигации по сайту*


<a id="console"></a>
## :keyboard: Запуск автотестов

***Локальный запуск тестов:***

Из корневой директории проекта выполнить:
```
gradle clean full_test -Denv=local  - запуск всех тестов локально
gradle clean buy_test -Denv=local   - запуск тестов на покупку локально
gradle clean search_test -Denv=local - запуск тестов на поиск локально
gradle clean navigation_test -Denv=local - запуск тестов на навигацию локально

```

<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="src/media/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Удаленный запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/student-dchizhova68-qa_guru23_jenkins_litres_autotest/)</a>

Для запуска сборки необходимо перейти в раздел <code>Build with parameters</code>, выбрать необходимые параметры и нажать кнопку <code>Build</code>.

###  Параметры сборки в Jenkins:
- BROWSER (браузер, по умолчанию chrome)
- BROWSER_VERSION (версия браузера, по умолчанию 100.0)
- BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)
- REMOTE_URL (адрес удаленного сервера)
- VIDEO_URL (адрес удаленного сервера, где храниться видео с записью автотеста)
- TASK (набор тестов для запуска)
- BASE_URL (адрес основной страницы тестируемого сайта)
  
<p align="center">
<img title="parametrs" src="src/media/screenshots/parametrs.JPG">
</p>


<a id="allure"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="src/media/logo/Allure.svg"> </a> Пример  [Allure-отчета](https://jenkins.autotests.cloud/job/student-dchizhova68-qa_guru23_jenkins_litres_autotest/allure/#suites/41277a3158bf1a31c2a3a799da365f5e/5360cc7af9e7f66d/) </a>  
Дождаться выполнения сборки. нажать на кнопку "Allure Report"

![jenkins](src/media/screenshots/AllureReport1.png "Отчет")

Пример Allure Report: 
![jenkins](src/media/screenshots/AllureReport.JPG "Пример отчета")

<a id="allure-testops"></a>
## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="src/media/logo/Allure_TO.svg"> </a> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4014/test-cases/30348?treeId=7852) </a> 

Реализована интеграция с <code>Allure TestOps</code>. Есть возможность просмотре результата выполнения автотестов и создания ручных тестов. 

<p align="center">
<img title="Allure TestOps DashBoard" src="src/media/screenshots/AllureTestOps.JPG">
</p>


<a id="jira"></a>
## <img width="4%" style="vertical-align:middle" title="Jira" src="src/media/logo/Jira.svg"> </a> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1095) </a> 

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в задаче отображаются связные автотесты и результат их выполнения.

<p align="center">
<img title="Jira Task" src="src/media/screenshots/JiraTask.JPG">
</p>


<a id="telegram"></a>
## <img width="4%" style="vertical-align:middle" title="Telegram" src="src/media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

Результаты выполнения автотестов отправляются в Telegram.

<p align="center">
<img width="70%" title="Telegram Notifications" src="src/media/screenshots/TelegramBot.JPG">
</p>


<a id="video"></a>
## <img width="4%" style="vertical-align:middle" title="Selenoid" src="src/media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплено видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="src/media/screenshots/testVideo.gif">
</p>
