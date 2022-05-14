package ru.mirea.khelimskiy.mireaproject;

public class ExampleItem {

        private String textdate;
        private String textdesc;
        private String textres;

        public ExampleItem(String text1, String text2, String text3) {
            textdate = text1;
            textdesc = text2;
            textres = text3;
        }

    public String textdate() {
            return textdate;
        }

        public String textdesc() {
            return textdesc;
        }

        public String textres() {
            return textres;
        }
    }


