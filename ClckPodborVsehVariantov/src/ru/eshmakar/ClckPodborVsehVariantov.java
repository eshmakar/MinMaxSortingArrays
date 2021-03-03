package ru.eshmakar;

//почему-то после продолжител. времени выдает: java heap out of memory
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ClckPodborVsehVariantov {
    public static void main(String[] args) {
        int count = 0;
        String url;
        System.out.print("Работу начал...\n");
        for (char nol = 'T'; nol <= 'z'; nol++) {
            if (propustit(nol)) continue;
            for (char nol2 = 'Y'; nol2 <= 'z'; nol2++) {
                if (propustit(nol2)) continue;
                for (char nol3 = 'A'; nol3 <= 'z'; nol3++) {
                    if (propustit(nol3)) continue;
                    for (char nol4 = '0'; nol4 <= 'z'; nol4++) {
                        if (propustit(nol4)) continue;
                        for (char nol5 = '0'; nol5 <= 'z'; nol5++) {
                            if (propustit(nol5)) continue;
                            url = String.format("https://clck.ru/%c%c%c%c%c", nol, nol2, nol3, nol4, nol5);
//                            System.out.println(url);
                            InputStream response = null;
                            try {
                                response = new URL(url).openStream();
                                Scanner scanner = new Scanner(response);
                                String responseBody = scanner.useDelimiter("\\A").next();
                                String titleFromSite = responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));
                                if (!titleFromSite.equals("Google Документы ‒ бесплатно создавайте и редактируйте документы в Интернете.")
                                        && !titleFromSite.equals("Google Таблицы ‒ бесплатно создавайте и редактируйте таблицы в Интернете.")
                                        && !titleFromSite.contains("Яндекс.Карты") && !titleFromSite.equals("Пройди тест на денежное мышление")
                                        && !titleFromSite.equals("Обратная связь - Группа медицинских компаний студия")
                                        && !titleFromSite.equals("МТС-Банк") && !titleFromSite.equals("Index - MerchantNew")
                                        && !titleFromSite.contains("РУСХИТ") && !titleFromSite.equals(" Google Карты ") && !titleFromSite.equals("Яндекс.Картинки")
                                        && !titleFromSite.equals("Срочноденьги Заявка") && !titleFromSite.equals("Best dating worldwide")
                                        && !titleFromSite.equals("Яндекс") && !titleFromSite.equals("МВД РОССИИ: УВЕДОМЛЕНИЕ О ШТРАФЕ")
                                        && !titleFromSite.equals("Страница оплаты") && !titleFromSite.contains("html") && !titleFromSite.equals("New phoenix")
                                        && !titleFromSite.equals("Корзина") && !titleFromSite.equals("Ru_kitchent at Taplink") && !titleFromSite.equals("Самолет")
                                        && !titleFromSite.contains("Авито") && !titleFromSite.equals("Оценка курьера") && !titleFromSite.equals("Добро пожаловать!")
                                        && !titleFromSite.contains("PeoplePass") && !titleFromSite.equals("axilog.ru - служба доставки")
                                        && !titleFromSite.equals("QIWI") && !titleFromSite.equals("Расчёт стоимости полиса ОСАГО онлайн")
                                        && !titleFromSite.contains("секс") && !titleFromSite.equals("Ваш заказ | Вилгуд")
                                        && !titleFromSite.contains("mistery") && !titleFromSite.equals("Как самозанятым получать бесплатные смены  — Яндекс.Про")
                                        && !titleFromSite.contains("xvideo") && !titleFromSite.contains("ЮMoney") && !titleFromSite.equals("Оплата")
                                        && !titleFromSite.contains("porno") && !titleFromSite.equals("") && !titleFromSite.contains("Линзмастер")
                                        && !titleFromSite.contains("Telegraph") && !titleFromSite.equals("Короткий URL для всех!")
                                        && !titleFromSite.contains("Ташкент") && !titleFromSite.equals(" ") && !titleFromSite.contains("Redirecting...")
                                        && !titleFromSite.equals("Get Laid Tonight") && !titleFromSite.equals("Ой!")
                                        && !titleFromSite.equals("PravSistem.Club") && !titleFromSite.equals("Warning! | There might be a problem with the requested link")
                                        && !titleFromSite.contains("Квартиры свободные") && !titleFromSite.equals("Статус заказа")) {
                                    System.out.println(url + " - " + titleFromSite + "(№: " + count++ + ")");
                                }
//                                System.out.println(++pop + ". " + url + " - " + titleFromSite);
                            } catch (Exception ex) {
                            } finally {
                                try {
                                    assert response != null;
                                    response.close();
                                } catch (Exception ex) {
                                }
//                            System.out.printf("%d. %c%c%c%c%c\n", count++, nol, nol2, nol3, nol4, nol5);
                      /*      temp = String.format("%d. %c%c%c%c%c\n", count++, nol, nol2, nol3, nol4, nol5);
                            if (temp.contains("TXR9S")) {
                                System.out.print(temp);
                                System.exit(0);
                            }*/
                            }

                        }
                    }
                }
            }
        }
    }

    private static boolean propustit(char a) {
        if (a == ':' || a == ';' || a == '<'
                || a == '=' || a == '>'
                || a == '?' || a == '@' || a == '[' || a == '\\'
                || a == ']' || a == '^' || a == '_' || a == '`') return true;
        return false;
    }
}
